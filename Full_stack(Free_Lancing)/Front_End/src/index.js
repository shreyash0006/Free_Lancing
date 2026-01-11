import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import "./header/style.css"
import {BrowserRouter, Route, Routes} from "react-router-dom"
import reportWebVitals from './reportWebVitals'
import { Prov } from './APIs_AND_Context/context';
import { ToastContainer } from 'react-toastify';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
  <Prov>
     <ToastContainer />
    <App />
  </Prov>
  </BrowserRouter>
);

reportWebVitals();
