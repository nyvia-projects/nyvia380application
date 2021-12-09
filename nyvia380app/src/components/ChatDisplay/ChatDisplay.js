import "./ChatDisplay.css"
import { Container } from "react-bootstrap";
import { useContext } from "react";
import AuthContext from "context/auth";


function ChatDisplay({messageList, selectedUser}) {

    const { user } = useContext(AuthContext)

    const renderMessages = () => {
        
        
        return messageList.filter(message => ( ((message.props?.sender === selectedUser) || (message.props?.sender === user))  && !(message.props.sender === user && message.props?.receiver !== selectedUser) ) ).map((message, index) => {
            return (
                <div className="message-block" style={message.props.sender === user ? {alignSelf: "end" } : {alignContent: "start"} }> 
                    <div key={`msg_${index}`}>
                        {message}
                    </div>
                </div>
            )
        })
    }

    return (
        <Container className="ChatDisplay">
            {selectedUser ? 
                <div className="message-header">
                    <span className="message-reciever">{selectedUser}</span>
                </div>

                : 

                <>
                </>
            }
            <div className="message-feed">
                {renderMessages()}
            </div>
        </Container>
    )
}

export default ChatDisplay;