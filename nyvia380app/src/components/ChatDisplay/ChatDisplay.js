import "./ChatDisplay.css"
import { Container } from "react-bootstrap";
import { useContext } from "react";
import AuthContext from "context/auth";


function ChatDisplay({messageList, selectedUser}) {

    const { user } = useContext(AuthContext)

    const renderMessages = () => {
        
        return messageList.filter(message => ((message.props?.sender === selectedUser) || (message.props?.sender === user)) ).map((message, index) => {
            if (message.props.sender === user)
                if (message.props?.receiver !== selectedUser)
                    return <></>;

            return (
                <div className="message-block" style={message.props.sender === user ? {alignSelf: "end" } : {} }> 
                    <div key={`msg_${index}`}>
                        {message}
                    </div>
                </div>
            )
        })
    }

    return (
        <Container className="ChatDisplay">
            <div className="message-feed">
                <span>{selectedUser}</span>
                {renderMessages()}
            </div>
        </Container>
    )
}

export default ChatDisplay;