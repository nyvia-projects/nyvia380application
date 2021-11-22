import "./ChatMenu.css"
import apiClient from "services/apiClient";
import { useEffect, useContext } from "react";
import AuthContext from "context/auth";


function ChatMenu ({friendList, setFriendList, selectedUser, setSelectedUser}) {

    const { user } = useContext(AuthContext)

    useEffect(() => {
        const fetchFriends = async () => {
            const res = await apiClient.fetchAllFriends()
            setFriendList(res.data)
        }
        
        fetchFriends() 
    }, [])

    const onFriendClick = (friend) => {

        setSelectedUser(friend)
    }

    const onXClick = (event) => {
        console.log("HERE")
        setSelectedUser(null)
        event.stopPropagation()
    }


    const loadFriends = () => {
        return friendList?.map((friendName, index) => {
            if (friendName === user) 
                return (<></>);

            return (
                <div onClick={() => onFriendClick(friendName)} className="wrapper">
                    <div id={"friend" + index} className="friend" style={selectedUser === friendName ? {backgroundColor: "#0C47AC"} : {}}>
                        <div className="flex-container">
                            <div className="friend-header">
                                <div className="friend-image">
                                    
                                </div>
                                <div className="friend-name">
                                    {friendName}
                                </div>
                            </div>
                            {selectedUser === friendName ?
                                <div onClick={onXClick} className="x-button">
                                    x
                                </div>

                                :

                                <></>

                            }
                        </div>
                    </div>
                </div>
        )})
    }
    

    return (
        <div className="ChatMenu">
            <div style={{marginBottom: "5px"}}>
                Welcome {user}
            </div>
            <div className="friend-list">
                {loadFriends()}
            </div>
        </div>
    )
}

export default ChatMenu;