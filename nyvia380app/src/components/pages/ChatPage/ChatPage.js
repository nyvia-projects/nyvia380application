import "./ChatPage.css"
import leftChevron from "../../../assets/chevron-left-square.png"
import rightChevron from "../../../assets/chevron-right-square.png"

import { ChatDisplay, ChatMenu, ChatTextBox, TextMessasge } from "components";
import { useState, useContext } from "react";
import ChatContext from "context/chat";

function ChatPage() {

    const { messageList, setMessageList, selectedUser, setSelectedUser } = useContext(ChatContext)
    const [friendList, setFriendList] = useState([])
    const [isOpen, setIsOpen] = useState(true)
    
    // const [temp, setTemp] = useState([])
    
    // useEffect(() => {
        
    //     const fetchMessages = () => {

    //         //Here you would iterate through api 
    //         temp.forEach(message => {
    //             createTextMessage(message)
    //         })
    //     }

    //     fetchMessages()
    // }, [])
    

    const createTextMessage = (textMessage, receiver, sender) => {
        if (textMessage === "" || textMessage == null) 
            return;

        setMessageList(messageHistory => [...messageHistory, <TextMessasge message={textMessage} receiver={receiver} sender={sender} />])
    }

    const onArrowClick = () => {
        setIsOpen(current => !current)
    }


    return (
        <div className="ChatPage">
            <div className="content-wrapper">
                <div className={`menu left-side flex-item ${isOpen ? "" : "closed"}`}>
                    <ChatMenu className="chatMenu" friendList={friendList} setFriendList={setFriendList} selectedUser={selectedUser} setSelectedUser={setSelectedUser} />
                </div>
                <div className="sidebar-section">
                    <div className={`sidebar-content ${isOpen ? "" : "closed"}`}>
                        {isOpen ?
                            <img className={`leftChevron sidebar-button`} src={leftChevron} onClick={onArrowClick} alt="left chevron" />

                            :

                            <img className={`rightChevron sidebar-button`} src={rightChevron} onClick={onArrowClick} alt="left chevron" />  
                        }
                    </div>
                </div>
                <div className="right-side flex-item">
                    <div className="display flex-item">
                        <ChatDisplay messageList={messageList} selectedUser={selectedUser} />
                    </div>
                    <div className="text-box-area flex-item">
                        <div className="text-box">
                            <ChatTextBox createTextMessage={createTextMessage} selectedUser={selectedUser} />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ChatPage;