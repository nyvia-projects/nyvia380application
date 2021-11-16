import "./TextMessage.css"
import profileImage from "../../assets/placeholder-image.png"


function TextMessage({message, sender, receiver}) {

    return (
        <div className="TextMessage">
            <div className="grid-container">
                <div className="grid-item">
                    <span className="text user-name">{sender}</span>
                </div>
                <div className="text text-message grid-item">
                    <span className="text-message-span" >{message}</span>
                </div>
            </div>
        </div>
    )
}

export default TextMessage;