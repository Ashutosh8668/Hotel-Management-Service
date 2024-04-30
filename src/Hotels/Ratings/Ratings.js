import React, { useEffect, useState } from 'react';
import axios from 'axios';
 // Import CSS file for styling

const Ratings = () => {
  const [ratings, setRatings] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8084/ratings/ratings/allratings');
        console.log('API Response:', response.data);
        setRatings(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching rating data:', error);
        setError('Error fetching rating data. Please try again later.');
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  console.log('Ratings:', ratings);

  return (
    <div>
      <div className='heading'>
        <center><h1>Rating List</h1></center>
      </div>
      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p>{error}</p>
      ) : ratings.length > 0 ? (
        <div className='table-container'>
          <table className='table'>
            <thead className='table-dark'>
              <tr>
                <th>Rating ID</th>
                <th>User ID</th>
                <th>Hotel ID</th>
                <th>Rating</th>
                <th>Feedback</th>
              </tr>
            </thead>
            <tbody>
              {ratings.map((ratingData) => (
                <tr key={ratingData.ratingId}>
                  <td>{ratingData.ratingId}</td>
                  <td>{ratingData.userId}</td>
                  <td>{ratingData.hotelId}</td>
                  <td>{ratingData.rating}</td>
                  <td>{ratingData.feedback}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ) : (
        <p>No ratings found.</p>
      )}
    </div>
  );
};

export default Ratings;
