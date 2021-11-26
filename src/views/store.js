/*eslint-disable*/
import React, { useState } from "react";
import "../App.css";
import Data from "./data.js";

// eslint-disable-next-line
import {
  Navbar,
  Container,
  Nav,
  NavDropdown,
  Button,
  Card,
  CardGroup,
  Carousel,
} from "react-bootstrap";

function Store() {
  let [product, Setproduct] = useState(Data);

  return (
    <div className="App">
      <Navbar bg="light" variant="light">
        <Container>
          <Navbar.Brand href="#home">TENNIS MANAGER</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">HOME</Nav.Link>
            <Nav.Link href="#features">INFO</Nav.Link>
            <Nav.Link href="#pricing">STORE</Nav.Link>
            <Nav.Link href="#competition">COMPETITION</Nav.Link>
            <Nav.Link href="#review">REVIEW</Nav.Link>
          </Nav>
          <Nav className="you-auto">
            <Nav.Link href="#sign">SIGN</Nav.Link>
            <Nav.Link href="#login">LOGIN</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <br></br>

      <div className="container">
        <div className="row">
          {product.map((a, i) => {
            return <Section product={product[i]} i={i} key={i} />;
          })}
        </div>
      </div>
    </div>
  );
}

function Section(props) {
  return (
    <div className="col-md-4">
      <Card style={{ width: "18rem" }}>
        <Card.Img
          variant="top"
          src={"/img/tennis_" + [props.i] + ".jpg"}
          width="100%"
        />
        <Card.Body>
          <Card.Title>{props.product.title}</Card.Title>
          <Card.Text>
            {props.product.content} <br />
            {props.product.price}
          </Card.Text>
          <Button variant="primary">구매하러가기</Button>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Store;
