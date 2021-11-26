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
// nodejs library that concatenates strings
import classnames from "classnames";

import { Link } from "react-router-dom";

// import logo from "assets/img/Logo_img.png";
import logo from "assets/img/Logo_mill.png";

// 생성한 EventCSS
import "assets/css/EventNavbar.css";

// reactstrap components
import {
  Button,
  Collapse,
  NavbarBrand,
  Navbar,
  NavItem,
  NavLink,
  Nav,
  Container,
} from "reactstrap";

function IndexNavbar() {
  const [navbarColor, setNavbarColor] = React.useState("navbar-transparent");
  const [navbarCollapse, setNavbarCollapse] = React.useState(false);

  const toggleNavbarCollapse = () => {
    setNavbarCollapse(!navbarCollapse);
    document.documentElement.classList.toggle("nav-open");
  };

  React.useEffect(() => {
    const updateNavbarColor = () => {
      if (
        document.documentElement.scrollTop > 299 ||
        document.body.scrollTop > 299
      ) {
        setNavbarColor("");
      } else if (
        document.documentElement.scrollTop < 300 ||
        document.body.scrollTop < 300
      ) {
        setNavbarColor("navbar-transparent");
      }
    };

    window.addEventListener("scroll", updateNavbarColor);

    return function cleanup() {
      window.removeEventListener("scroll", updateNavbarColor);
    };
  });
  return (
    <Navbar expand="lg" className="nav-header">
      <Container>
        <div className="navbar-translate">
          <Link to="/index">
            <NavbarBrand
              data-placement="bottom"
              target="_blank"
              title="Coded by Creative Tim"
            >
              <img src={logo} />
            </NavbarBrand>
          </Link>

          <Link to="/">
            <NavbarBrand
              data-placement="bottom"
              target="_blank"
              title="Coded by Creative Tim"
            >
              얌얌메뉴
            </NavbarBrand>
          </Link>

          <Link to="/">
            <NavbarBrand
              data-placement="bottom"
              target="_blank"
              title="Coded by Creative Tim"
            >
              게시판
            </NavbarBrand>
          </Link>

          <button
            aria-expanded={navbarCollapse}
            className={classnames("navbar-toggler navbar-toggler", {
              toggled: navbarCollapse,
            })}
            onClick={toggleNavbarCollapse}
          >
            <span className="navbar-toggler-bar bar1" />
            <span className="navbar-toggler-bar bar2" />
            <span className="navbar-toggler-bar bar3" />
          </button>
        </div>
        <Collapse
          className="justify-content-end"
          navbar
          isOpen={navbarCollapse}
        >
          <Nav navbar>
            <Link to="/index">
              <NavItem>
                <NavLink data-placement="bottom" target="_blank">
                  <p className="d-lg-none">얌얌키트 로고</p>
                </NavLink>
              </NavItem>
            </Link>
            <Link to="/">
              <NavItem>
                <NavLink
                  data-placement="bottom"
                  target="_blank"
                  title="Like us on Facebook"
                >
                  <p className="d-lg-none">얌얌메뉴</p>
                </NavLink>
              </NavItem>
            </Link>
            <Link to="/">
              <NavItem>
                <NavLink data-placement="bottom" title="Follow us on Instagram">
                  <p className="d-lg-none">게시판</p>
                </NavLink>
              </NavItem>
            </Link>

            <NavItem>
              <Link to="/login-page">
                <Button className="btn-round" color="danger" target="_self">
                  <i className="nc-icon nc-bulb-63"></i>
                  로그인
                </Button>
              </Link>
              <Link to="/register-page">
                <Button className="btn-round" color="danger" target="_self">
                  <i className="nc-icon nc-bulb-63"></i>
                  회원가입
                </Button>
              </Link>
            </NavItem>
          </Nav>
        </Collapse>
      </Container>
    </Navbar>
  );
}

export default IndexNavbar;
