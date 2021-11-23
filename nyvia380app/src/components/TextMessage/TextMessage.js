import "./TextMessage.css"
import { useContext } from "react";
import AuthContext from "context/auth";


function TextMessage({message, sender, receiver}) {

    const {user} = useContext(AuthContext)

    return (
        <div className="TextMessage">
            <div className="grid-container">
                <div className={`user-name ${user === sender ? "user" : ""} grid-item`}>
                    <span className="text user-name">{sender}</span>
                </div>
                <div className={`text text-message ${user === sender ? "user" : ""} grid-item`}>
                    <span className="text-message-span">{message}</span>
                </div>
            </div>
        </div>
    )
}

export default TextMessage;