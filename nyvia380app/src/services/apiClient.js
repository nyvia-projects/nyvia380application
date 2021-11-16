import axios from "axios";
import Stomp from 'stompjs'
import SockJS from 'sockjs-client'
import { useState } from "react";

var stompClient;
var subscription;

class ApiClient {

    constructor(remoteHostUrl) {
        
        this.remoteHostUrl = remoteHostUrl;
        // this.token = null;
        // this.tokenName = "token";
    }
    
    // utility method...
    async request({endpoint, method = `GET`, data = {}}) {
        const url = `${this.remoteHostUrl}${endpoint}`;
        console.log(url)
        const headers = {
            "Content-Type": "application/json"
        }

        try {
            const res = await axios({url, method, data, headers}); //passing config methods to axios
            return {data: res.data, error: null};
        } catch (error) {
            const errorResponse = error?.response?.data?.error?.message;
            return {data: null, error: errorResponse || String(error)};
        }
    }

    async requestStompClient({endpoint, method, header = {}, data = {}}) {

        try {
            let res;
            switch (method) {
                case "send":
                    res = await stompClient.send(endpoint, header, data);  
                    return {data: res.data, error: null};

                case "connect":
                    
                    break;
                
                default:
                    break;
            }
        } catch (error) {
            const errorResponse = error?.response?.data?.error?.message;
            return {data: null, error: errorResponse || String(error)};
        }
    }

    async connect(userName, callBack) {

        let socket = new SockJS(this.remoteHostUrl + '/Nyvia380')
        stompClient = await Stomp.over(socket)

        await stompClient.connect({}, async function (frame) {
            console.log("connected to: " + frame)

            subscription = await stompClient.subscribe(`/topic/chat/${userName}`, callBack)
        });

    }

    async disconnect () {
        if (stompClient !== null) {
            stompClient.disconnect((frame) => {
                console.log("DISCONNECTED" + frame)
g        }
    }


    async unsubscribe () {
        await subscription.unsubscribe()
    }

    // async subscribe () {
    //     await stompClient.subscribe("/topic/greetings", function (greeting) {
    //         let data = JSON.parse(greeting.body).content
    //         console.log("DATA: " + greeting.body)
    //     });

    //     await stompClient.subscribe("/topic/greetings", function (greeting) {
    //         let data = JSON.parse(greeting.body).content
    //         console.log("DATA: " + greeting.body)
    //     });
    // }

    async register(userName) {
        return this.request({ endpoint: `/register/${userName}`, method: "GET" })
    }
    
    async login(userName) {
        return this.request({ endpoint: `/login/${userName}`, method: "GET" })
    }

    async signout () {
    
    }

    async fetchAllFriends() {
        return this.request({ endpoint: "/fetchAllUsers", method: "GET" })
    }

    async sendName(userName) {
        return this.requestStompClient({ endpoint: "/app/hello", method: "send", data: JSON.stringify({'name': userName}) });
    }

    async sendMessageTo(message, receiver, sender) {
        return this.requestStompClient({ endpoint: `/app/chat/${receiver}`, method: "send", data: JSON.stringify({'message': message, 'sender': sender}) })
    }

}

export default new ApiClient("http://localhost:8080");
