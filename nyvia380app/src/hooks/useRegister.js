import apiClient from "services/apiClient";
import { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "context/auth";
import { useAuth } from "./useAuth";

export const useRegister = () => {
  const navigate = useNavigate();
  const { user, setUser} = useContext(AuthContext);
  const { receiveMessage } = useAuth();
  const [passwordStrength, setPasswordStrength] = useState("");
  const [isProcessing, setIsProcessing] = useState();
  const [errors, setErrors] = useState({});
  const [form, setForm] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    confirmPassword: "",
  });


  const handleOnTextChange = (evt) => {

    switch(evt.target.name) {
      case "email":
        if (evt.target.value.indexOf("@") <= 0 && evt.target.value.indexOf(".") <= 0)
          setErrors((err) => ({ ...err, email: "Please enter a valid email." }));
        else 
          setErrors((err) => ({ ...err, email: null }));
        break;

      case "firstName": 
      case "lastName":
        if (evt.target.value.trim() === "")
          setErrors((err) => ({ ...err, [evt.target.name]: "Please enter a name."}))
        else 
          setErrors((err) => ({ ...err, [evt.target.name]: null }))
        break;

      case "password":
        if (form.confirmPassword !== "") {
          if (evt.target.value !== form.confirmPassword || evt.target.value.trim() === "")
            setErrors((err) => ({
              ...err,
              confirmPassword: "Passwords do not match.",
            }));
          else 
            setErrors((err) => ({ ...err, confirmPassword: null }));
        }

        determineStrength(evt.target.value)
        break;

      case "confirmPassword": 
      if (evt.target.value !== form.password || evt.target.value.trim() === "")
        setErrors((err) => ({
          ...err,
          confirmPassword: "Passwords do not match.",
        }));
      else
        setErrors((err) => ({ ...err, confirmPassword: null }));
        break;

      default:
        break;
    }

    setForm((oldForm) => ({ ...oldForm, [evt.target.name]: evt.target.value }));
    
  }

  const handleOnClickSubmit = async (evt) => {
    evt.preventDefault();
    setIsProcessing(true);
    setErrors((err) => ({ ...err, form: null }));
    console.log("REGISTER")

    /**TEMP REGISTER METHOD */
    const { data, error } = await apiClient.register(form.email)
    // const { data, error } = await apiClient.register({
    //   firstName: form.firstName,
    //   lastName: form.lastName,
    //   email: form.email,
    //   password: form.password,
    // });

    if (error) setErrors((err) => ({ ...err, form: error }));

    if (data?.username) {
      setUser(data.username)
      navigate("/messages");
      await apiClient.connect(data.username, receiveMessage)
    }

    setIsProcessing(false);
  };

  const determineStrength = (password) => {
    const length = password.length

    if (length < 8) {
      setPasswordStrength("Weak")
    } else if (length >= 8 && length <= 13) {
      setPasswordStrength("Medium")
    } else {
      setPasswordStrength("Strong")
    }
  }

  return {
    isProcessing,
    errors,
    form,
    passwordStrength,
    determineStrength,
    handleOnTextChange,
    handleOnClickSubmit,
  };
};
