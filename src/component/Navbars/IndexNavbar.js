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
import { Link } from "react-router-dom";
// nodejs library that concatenates strings
import classnames from "classnames";
// reactstrap components

// 로고
// import logo from "assets/img/yumyumlogo.png";

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
    <Navbar className={classnames("fixed-top", navbarColor)} expand="lg">
      <Container>
        <div className="navbar-translate">
          <Link to="/index">
            <NavbarBrand
              data-placement="bottom"
              target="_self"
              title="Coded by Creative Tim"
            >
              <img
                src={process.env.PUBLIC_URL + "img/yumyumlogo.png"}
                style={{ width: "100px", height: "80px" }}
              />
            </NavbarBrand>
          </Link>

          {/* 메뉴 화면으로 이동 */}
          <Link to="/">
            <NavbarBrand
              ata-placement="bottom"
              target="_self"
              title="Coded by Creative Tim"
            >
              얌얌메뉴
            </NavbarBrand>
          </Link>

          {/* 이벤트 화면으로 이동 */}
          <Link to="/">
            <NavbarBrand
              ata-placement="bottom"
              target="_self"
              title="Coded by Creative Tim"
            >
              얌얌이벤트
            </NavbarBrand>
          </Link>

          {/* 게시판 화면으로 이동 */}
          <Link to="/">
            <NavbarBrand
              ata-placement="bottom"
              target="_self"
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
            {/* 로고 부분 사용 안함 */}
            {/* <NavItem>
              <NavLink
                data-placement="bottom"
                href="#"
                target="_blank"
                title="로고"
              >
              </NavLink>
            </NavItem> */}

            {/* 메뉴 화면으로 이동 */}
            <Link to="/">
              <NavLink data-placement="bottom" target="_blank" title="메뉴">
                {/* <i className="fa fa-facebook-square" /> */}
                <p className="d-lg-none">얌얌메뉴</p>
              </NavLink>
            </Link>

            {/* 이벤트 화면으로 이동 */}
            <Link to="/">
              <NavLink data-placement="bottom" target="_blank" title="이벤트">
                {/* <i className="fa fa-instagram" /> */}
                <p className="d-lg-none">얌얌이벤트</p>
              </NavLink>
            </Link>

            {/* 게시판 화면으로 이동 */}
            <Link to="/">
              <NavLink data-placement="bottom" target="_blank" title="게시판">
                {/* <i className="fa fa-github" /> */}
                <p className="d-lg-none">게시판</p>
              </NavLink>
            </Link>

            <NavItem>
              <Link to="/login-page">
                <Button className="btn-round" color="danger" target="_self">
                  <i className="nc-icon nc-bulb-63"></i> 로그인
                </Button>
              </Link>
              <Link to="/register-page">
                <Button className="btn-round" color="danger" target="_self">
                  <i className="nc-icon nc-bulb-63"></i> 회원가입
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
