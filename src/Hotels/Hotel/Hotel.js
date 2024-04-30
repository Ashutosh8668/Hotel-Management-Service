import React, { useEffect, useState } from 'react';
import axios from 'axios';


const Hotel = () => {
  const [hotels, setHotels] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8084/hotels/hotels/allhotels');
        console.log('API Response:', response.data);
        setHotels(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching hotel data:', error);
        setError('Error fetching hotel data. Please try again later.');
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  console.log('Hotels:', hotels);

  return (
    <div>
      <div className='heading'>
        <center><h1>Hotel List</h1></center>
      </div>
      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p>{error}</p>
      ) : hotels.length > 0 ? (
        <div className='table-container'>
          <table className='table'>
            <thead className='table-dark'>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Location</th>
                <th>About</th>
              </tr>
            </thead>
            <tbody>
              {hotels.map((hotelData) => (
                <tr key={hotelData.id}>
                  <td>{hotelData.id}</td>
                  <td>{hotelData.name}</td>
                  <td>{hotelData.location}</td>
                  <td>{hotelData.about}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ) : (
        <p>No hotels found.</p>
      )}
    </div>
  );
};

export default Hotel;
