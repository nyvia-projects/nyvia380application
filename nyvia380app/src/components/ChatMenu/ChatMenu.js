import "./ChatMenu.css"
import apiClient from "services/apiClient";
import { useEffect, useContext } from "react";
import AuthContext from "context/auth";


function ChatMenu ({friendList, setFriendList, selectedUser, setSelectedUser}) {

    const { user } = useContext(AuthContext)

    useEffect(() => {
        const fetchFriends = async () => {
            const res = await apiClient.fetchAllUsers()
            setFriendList(res.data)
        }
        
        fetchFriends() 
    }, [])

    const onFriendClick = (friend) => {

        setSelectedUser(friend)
    }

    const onXClick = (event) => {
        setSelectedUser(null)
        event.stopPropagation()
    }

    const reloadFriends = async () => {
        const res = await apiClient.fetchAllUsers()
        setFriendList(res.data)
    }

    const loadFriends = () => {
        return friendList?.map((friend, index) => {
            if (friend.alias === user) 
                return (<></>);

            return (
                <div onClick={() => onFriendClick(friend.alias)} className="wrapper">
                    <div id={"friend" + index} className="friend" style={selectedUser === friend.alias ? {backgroundColor: "#0C47AC"} : {}}>
                        <div className="flex-container">
                            <div className="friend-header">
                                <div className="friend-image">
                                    
                                </div>
                                <div className="friend-name">
                                    {friend.alias}
                                </div>
                            </div>
                            {selectedUser === friend.alias ?
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
            {/* <div style={{marginBottom: "5px"}}>
                Welcome {user}
            </div> */}
            <div className="reload-btn" onClick={reloadFriends}>
            <i className="gg-redo"></i><div>RELOAD</div>
            </div>
            <div className="friend-list">
                {loadFriends()}
            </div>
        </div>
    )
}

export default ChatMenu;