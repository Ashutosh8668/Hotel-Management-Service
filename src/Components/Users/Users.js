import React, { useEffect, useState } from 'react';
// import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Users.css'; // Import CSS file for styling

const Users = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8084/users/users/allusers');
        console.log('API Response:', response.data);
        setUsers(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching user data:', error);
        setError('Error fetching user data. Please try again later.');
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  console.log('Users:', users);

  return (
    <div>
      <div className='heading' ><center><h1>User List</h1></center></div>
      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p>{error}</p>
      ) : users.length > 0 ? (
        <div className='table-container'>
          <table className='table'>
            <thead className='table-dark'>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>About</th>
              </tr>
            </thead>
            <tbody>
              {users.map((userData) => (
                <tr key={userData.userId}>
                  <td>{userData.userId}</td>
                  <td>{userData.name}</td>
                  <td>{userData.email}</td>
                  <td>{userData.about}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ) : (
        <p>No users found.</p>
      )}
    </div>
  );
};

export default Users;
