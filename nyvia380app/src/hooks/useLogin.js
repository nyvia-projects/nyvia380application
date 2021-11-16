import { useContext, useState } from "react";
import { useNavigate } from "react-router";
import apiClient from "services/apiClient";
import AuthContext from "context/auth";
import { useAuth } from "./useAuth";

export const useLogin = () => {
  const navigate = useNavigate();
  const { user, setUser } = useContext(AuthContext);
  const { receiveMessage, setNewMessage } = useAuth();
  const [isProcessing, setIsProcessing] = useState(false);
  const [errors, setErrors] = useState({});
  const [form, setForm] = useState({
    email: "",
    password: "",
  });

  const handleOnTextChange = (evt) => {
    if (evt.target.name === "email") {
      if (evt.target.value.indexOf("@") <= 0 && evt.target.value.indexOf(".") <= 0)
        setErrors((err) => ({ ...err, email: "Please enter a valid email." }));
      else setErrors((err) => ({ ...err, email: null }));
    }

    setForm((oldForm) => ({ ...oldForm, [evt.target.name]: evt.target.value }));
  };

  const handleOnClickSubmit = async (evt) => {
    evt.preventDefault();
    setIsProcessing(true);
    setErrors((err) => ({ ...err, form: null }));

    /**TEMP LOGIN METHOD */
    const { data, error } = await apiClient.login(form.email)

    if (error) {
      setErrors((err) => ({ ...err, form: error }));
    }
    
    if (data?.username) {
      setUser(data.username)
      navigate("/messages");
      await apiClient.connect(data.username, receiveMessage)
    }

    setIsProcessing(false);
  };

  

  return {
    isProcessing,
    errors,
    form,
    handleOnTextChange,
    handleOnClickSubmit,
  };
};
