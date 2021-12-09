import { useContext, useState } from "react";
import { useNavigate } from "react-router";
import apiClient from "services/apiClient";
import AuthContext from "context/auth";
import { useAuth } from "./useAuth";

export const useLogin = () => {
  const navigate = useNavigate();
  const { setUser } = useContext(AuthContext);
  const { receiveMessage } = useAuth();
  const [isProcessing, setIsProcessing] = useState(false);
  const [errors, setErrors] = useState({});
  const [form, setForm] = useState({
    alias: ""
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

    const { data, error } = await apiClient.login({
      firstName: "null",
      lastName: "null",
      age: "null",
      privilege: "NONE",
      alias: form.alias
    })

    if (error) {
      setErrors((err) => ({ ...err, form: error }));
    }
    
    if (data?.age !== 0) {
      setUser(data?.alias)
      navigate("/messages");
      await apiClient.connect(data.alias, receiveMessage)
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
