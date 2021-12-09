import axios from "axios";
import Stomp from 'stompjs'
import SockJS from 'sockjs-client'

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
            subscription = await stompClient.subscribe(`/topic/chat/${userName}`, callBack)
        });

    }

    async disconnect () {
        if (stompClient !== null) {
            stompClient.disconnect()
        }
    }


    async unsubscribe () {
        await subscription.unsubscribe()
    }


    async register(userInfo) {
        console.log(userInfo)
        return this.request({ endpoint: `/register`, method: "POST", data: userInfo })
    }
    
    async login(userName) {
        return this.request({ endpoint: `/login/${userName}`, method: "GET" })
    }

    async signout () {
        return;
    }

    async fetchAllUsers() {
        return this.request({ endpoint: "/users/all", method: "GET" })
    }

    async fetchAllFriends() {
        return this.request({ endpoint: "/fetchAllUsers", method: "GET" })
    }

    async sendMessageTo(message, receiver, sender) {
        return this.requestStompClient({ endpoint: `/app/chat/${receiver}`, method: "send", data: JSON.stringify({'message': message, 'sender': sender}) })
    }

}

export default new ApiClient("http://localhost:8080");
