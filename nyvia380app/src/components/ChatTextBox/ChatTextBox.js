import "./ChatTextBox.css"
import { InputGroup, FormControl, Form} from "react-bootstrap";
import { useContext, useState } from "react";
import apiClient from "services/apiClient";
import AuthContext from "context/auth";


function ChatTextBox({createTextMessage, selectedUser}) {
    const { user } = useContext(AuthContext)
    const [textMessage, setTextMessage] = useState("");

    const handleOnMessageChange = (event) => {
        setTextMessage(event.target.value)
    }

    const handleOnSubmit = async (event) => {
        event.preventDefault()

        if (textMessage === "")
            return;

        createTextMessage(textMessage, selectedUser, user)
        await apiClient.sendMessageTo(textMessage, selectedUser, user)
        setTextMessage("")

    }

 
    return (
        <div className="ChatTextBox">
            <Form onSubmit={handleOnSubmit}>
                <InputGroup size="lg">

                    {selectedUser ?
                        <>
                            <div className="import-button">
                                <i className="plus-icon gg-add-r"></i>
                            </div>
                            <FormControl
                                type="text"
                                id="text-field"
                                placeholder="Message"
                                onChange={handleOnMessageChange}
                                value={textMessage}
                                autoFocus
                            /> 
                            <div onClick={handleOnSubmit} className="sendArrow" >
                                <i class="ai-send"></i>
                            </div>
                        </>

                        :

                        <></>
                    }
                </InputGroup>
            </Form>
        </div>
    )
}

export default ChatTextBox;