import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";

import LoginPage from "./views/examples/LoginPage.js";
import RegisterPage from "./views/examples/RegisterPage.js";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/index" render={(props) => <App {...props} />} />
      {/* <Route path="/event" render={(props) => <Event {...props} />} /> */}
      <Route
        path="/register-page"
        render={(props) => <RegisterPage {...props} />}
      />
      <Route path="/login-page" render={(props) => <LoginPage {...props} />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
