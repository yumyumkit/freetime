/*eslint-disable*/
import React from "react";
import "assets/css/EventNavbar.css";

// reactstrap components
import { Container } from "reactstrap";

function EventFooter() {
  return (
    <footer className="footer register-footer text-center">
      <Container>
        <div>
          <h6 className="footerColor">
            © {new Date().getFullYear()}, made with{" "}
            <i className="fa fa-heart heart" /> by Creative Tim
          </h6>
        </div>
      </Container>
    </footer>
  );
}

export default EventFooter;
