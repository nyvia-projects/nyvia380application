import { useContext } from "react";
import ChatContext from "context/chat";
import TextMessage from "components/TextMessage/TextMessage";

export const useAuth = () => {

    const { setMessageList } = useContext(ChatContext)

    function receiveMessage (message) {
        let data = JSON.parse(message.body)
        setMessageList(messageHistory => [...messageHistory, <TextMessage message={data.message} sender={data.sender} />])
    }

    return {
        receiveMessage,
    };
}