import React, { useState, useEffect } from "react";
import logo from "./logo.svg";
import "./App.css";
import Photos from './components/Photos'

const App = () => {
  const [photos, setPhotos] = useState([]);

  useEffect(() => {
    const getPhotos = async () => {
      const photosFromServer = await fecthPhotos();
      setPhotos(photosFromServer)
    };

    getPhotos();
  }, []);

  const fecthPhotos = async () => {
    const res = await fetch("http://localhost:9100/api/v1/photo");
    const data = await res.json();

    return data;
  };


  return (
    <div className="App">
      <h1>Médiathèque : </h1>
      <Photos photos={photos}/>
    </div>
  );
};

export default App;
