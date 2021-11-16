import "./ChatMenu.css"
import apiClient from "services/apiClient";
import { useEffect, useState, useContext } from "react";
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


    const loadFriends = () => {
        return friendList?.map((element, index) => {
            if (element === user) 
                return (<></>);

            return (
                <div onClick={() => onFriendClick(element)} className="wrapper">
                    <div id={"friend" + index} className="friend">
                        <div className="flex-container">
                            <div className="friend-image">
                                
                            </div>
                            <div className="friend-name">
                                {element}
                            </div>
                        </div>
                    </div>
                </div>
        )})
    }
    

    return (
        <div className="ChatMenu">
            <div>
                <div>
                    Welcome {user}
                </div>
                <div className="friend-list">
                    {loadFriends()}
                </div>
            </div>
        </div>
    )
}

export default ChatMenu;