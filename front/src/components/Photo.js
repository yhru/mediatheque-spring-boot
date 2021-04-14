import React from "react";

const Photo = ( {photo} ) => {
  return (
    <div>
      <h3>{photo.file_name}</h3>
      <img src={photo.dataInPicture} alt={photo.file_name} />
    </div>
  );
};

export default Photo;
