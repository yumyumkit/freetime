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
import { Button, Card, Form, Input, Container, Row, Col } from "reactstrap";

// import naver from "assets/img/icons/naver-ico.png";
// import kakao from "assets/img/icons/kakao-logo.png";

// core components
import IndexNavbar from "components/Navbars/IndexNavbar";

function LoginPage() {
  document.documentElement.classList.remove("nav-open");
  React.useEffect(() => {
    document.body.classList.add("register-page");
    return function cleanup() {
      document.body.classList.remove("register-page");
    };
  });
  return (
    <>
      <IndexNavbar />
      <div
        className="page-header"
        style={{ background: "url(img/good_food.jpg)" }}
      >
        <div className="filter" />
        <Container>
          <Row>
            <Col className="ml-auto mr-auto" lg="4">
              <Card className="card-register ml-auto mr-auto">
                <h3 className="title mx-auto">환영합니다</h3>
                <div className="social-line text-center">
                  {/* 로그인 API 버튼 추가 구역 */}
                  <Button
                    className="btn-neutral btn-just-icon mr-1"
                    color="google"
                    href="#pablo"
                    onClick={(e) => e.preventDefault()}
                  >
                    <i className="fa fa-google-plus" />
                  </Button>

                  <Button
                    className="btn-neutral btn-just-icon mr-1"
                    href="#"
                    onClick={(e) => e.preventDefault()}
                  >
                    <img
                      src={process.env.PUBLIC_URL + "img/icons/naver-ico.png"}
                    />
                  </Button>

                  {/* 카카오 버튼 추가 부분 */}
                  <Button
                    className="btn-neutral btn-just-icon"
                    href="#"
                    onClick={(e) => e.preventDefault()}
                  >
                    <img
                      src={process.env.PUBLIC_URL + "img/icons/kakao-logo.png"}
                    />
                  </Button>
                </div>
                <Form className="register-form">
                  <label>이메일</label>
                  <Input placeholder="이메일" type="text" />
                  <label>비밀번호</label>
                  <Input placeholder="비밀번호" type="password" />
                  <Button
                    block
                    className="btn-round"
                    color="danger"
                    href="register-page"
                  >
                    로그인
                  </Button>
                </Form>
                {/* <div className="forgot">
                  <Button
                    className="btn-link"
                    color="danger"
                    href="#pablo"
                    onClick={(e) => e.preventDefault()}
                  >
                   
                  </Button>
                </div> */}
              </Card>
            </Col>
          </Row>
        </Container>
        <div className="footer register-footer text-center">
          <h6>
            © {new Date().getFullYear()}, made with{" "}
            <i className="fa fa-heart heart" /> by Creative Tim
          </h6>
        </div>
      </div>
    </>
  );
}

export default LoginPage;
