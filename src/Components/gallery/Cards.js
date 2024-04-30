import React, { useState } from "react";

const Cards = (props) => {
  const [popup, setPopup] = useState(false);

  const toggleModal = () => {
    setPopup(!popup);
  };

  return (
    <>
      <div className='gallery-item'>
        <div className='gallery-image'>
          <img src={props.images} alt='Gallery Image' />
          <i className='fas fa-image' onClick={toggleModal}></i>
        </div>
        <div className='gallery-title'>
          <h3>{props.title} </h3>
        </div>
      </div>

      {popup && (
        <div className='modal'>
          <div className='modal-content'>
            <button onClick={toggleModal}>Close</button>
            <img src={props.images} alt='Gallery Image' />
          </div>
        </div>
      )}
    </>
  );
};

export default Cards;
