import "./App.css";
import AuthContext from "context/auth";
import ChatContext from "context/chat";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import { ChatPage, HomePage, Login, Register, Admin } from "components/pages";
import { NavBar } from "components";
import apiClient from "services/apiClient";


function App() {

  const [user, setUser] = useState(null)
  const [selectedUser, setSelectedUser] = useState(null)
  const [messageList, setMessageList] = useState([])

  const signout = () => {
    setUser(null)
    setSelectedUser(null)
    setMessageList([])
    apiClient.disconnect()
}


  return (
    <AuthContext.Provider value={{ user, setUser, signout }}>
      <ChatContext.Provider value={{messageList, setMessageList, selectedUser, setSelectedUser }}>
        <div className="App">
          <div className="content-wrapper flex-container">
            <BrowserRouter>
                <NavBar />

              <Routes>
                <Route path="/" />
                <Route path="/home" element={<HomePage />} />
                <Route path="/messages" element={<ChatPage />} />
                <Route path="/about" />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/admin" element={<Admin />} />
                <Route path="/signout" />
              </Routes>
            </BrowserRouter>
          </div>
        </div>
      </ChatContext.Provider>
    </AuthContext.Provider>
  );
}

export default App;
