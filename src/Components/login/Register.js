// Register.js
import React, { useEffect, useState } from "react";
import axios from "axios";
import HeadTitle from "../../Common/HeadTitle/HeadTitle";
import "./design.css";

const Register = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [cpassword, setCpassword] = useState("");
  const [about, setAbout] = useState("");
  const [recValue, setRecValue] = useState([]);

  // Function to send data to the backend
  const sendDataToBackend = async (userData) => {
    try {
      // Send a POST request to the backend endpoint
      const response = await axios.post("http://localhost:8084/users/users/register", userData);
      console.log(response.data);

      // You may want to do something with the response, or handle success accordingly
    } catch (error) {
      console.error("Error sending data to the backend:", error);
    }
  };

  const submitForm = (e) => {
    e.preventDefault();

    try {
      const newUser = { name, email, password, cpassword, about };

      // Call the function to send data to the backend
      sendDataToBackend(newUser);

      // Update the state with the new user data
      setRecValue([...recValue, newUser]);

      // Clear the form fields after successful registration
      setName("");
      setEmail("");
      setPassword("");
      setCpassword("");
      setAbout("");
    } catch (error) {
      console.error("Error:", error);
    }
  };

  useEffect(() => {
    // Load users or any other initial setup if needed
  }, []);

  return (
    <>
      <HeadTitle />
      <section className='forms top'>
        <div className='container'>
          <div className='sign-box'>
            <p>Don't have an account? Create your account, it takes less than a minute.</p>
            <form onSubmit={submitForm}>
              <input type='text' name='name' value={name} onChange={(e) => setName(e.target.value)} placeholder='Name' required />
              <input type='email' name='email' value={email} onChange={(e) => setEmail(e.target.value)} placeholder='Email' required />
              <input type='password' name='password' value={password} onChange={(e) => setPassword(e.target.value)} placeholder='Password' required />
              <input type='password' name='cpassword' value={cpassword} onChange={(e) => setCpassword(e.target.value)} placeholder='Confirm Password' required />
              <input type='text' name='about' value={about} onChange={(e) => setAbout(e.target.value)} placeholder='About' required />
              <button type='submit' className='primary-btn'>
                Create an Account
              </button>
            </form>
          </div>
        </div>
      </section>

      <section className='show-data'>
        {recValue.map((currentValue, index) => (
          <div className='sign-box' key={index}>
            <h1>Create an Account Successfully</h1>
            <h3>
              Name: <p>{currentValue.name}</p>
            </h3>
            <h3>
              Email: <p>{currentValue.email}</p>
            </h3>
            <h3>
              Password: <p>{currentValue.password}</p>
            </h3>
            <h3>
              Confirm Password: <p>{currentValue.cpassword}</p>
            </h3>
            <h3>
              About: <p>{currentValue.about}</p>
            </h3>
          </div>
        ))}
      </section>
    </>
  );
};

export default Register;
