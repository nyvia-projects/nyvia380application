import "./App.css";
import AuthContext from "context/auth";
import ChatContext from "context/chat";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import { ChatPage, HomePage, Login, Register } from "components/pages";
import { NavBar } from "components";


function App() {

  const [user, setUser] = useState(null)
  const [messageList, setMessageList] = useState([])
  const [selectedUser, setSelectedUser] = useState(null)


  return (
    <AuthContext.Provider value={{ user, setUser }}>
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
