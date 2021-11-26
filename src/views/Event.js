/*!

=========================================================
* Paper Kit React - v1.3.0
=========================================================

* Product Page: https://www.creative-tim.com/product/paper-kit-react

* Copyright 2021 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/paper-kit-react/blob/main/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import React from "react";

// reactstrap components
import { Container } from "reactstrap";

// core components
import EventNavbar from "components/Navbars/EventNavbar";
import Eventmain from "components/Events/Eventmain";
import EventmainWrite from "components/Events/EventmainWrite";
import EventFooter from "components/Footers/EventFooter";

import "assets/css/EventNavbar.css";

function Event() {
  document.documentElement.classList.remove("nav-open");
  React.useEffect(() => {
    document.body.classList.add("event");
    return function cleanup() {
      document.body.classList.remove("event");
    };
  });
  return (
    <>
      <EventNavbar />

      <div className="page-header main-back">
        <Container className="nav-header">
          <div>
            <Eventmain />
          </div>
          <div>
            <EventmainWrite />
          </div>
        </Container>

        <EventFooter />
      </div>
    </>
  );
}

export default Event;
