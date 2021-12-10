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

        console.log(url)
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
        return this.request({ endpoint: `/register`, method: "POST", data: userInfo })
    }
    
    async login(userInfo) {
        return this.request({ endpoint: `/login`, method: "POST", data: userInfo })
    }

    async signout () {
        return;
    }

    async fetchUserByUsername(username) {
        return this.request({ endpoint: `/users/findUserByAlias/${username}`, method: "GET" })
    }

    async fetchAllUsers() {
        return this.request({ endpoint: "/users/all", method: "GET" })
    }

    async sendMessageTo(message, receiver, sender) {
        return this.requestStompClient({ endpoint: `/app/chat/${receiver}`, method: "send", data: JSON.stringify({'sender': sender, 'receiver': receiver, 'message': message}) })
    }

    async fetchAllMessages(alias) {
        return this.request({ endpoint: `/chat/${alias}/fetchAllMessages`, method: "GET" })
    }

}

export default new ApiClient("http://localhost:8080");
