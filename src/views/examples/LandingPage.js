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
import { Button, Container, Row, Col } from "reactstrap";
import DemoFooter from "../../component/Footers/DemoFooter";
import IndexHeader from "../../component/Headers/IndexHeader";
import IndexNavbar from "../../component/Navbars/IndexNavbar";

function LandingPage() {
  document.documentElement.classList.remove("nav-open");
  React.useEffect(() => {
    document.body.classList.add("profile-page");
    return function cleanup() {
      document.body.classList.remove("profile-page");
    };
  });
  return (
    <>
      <IndexHeader />
      <IndexNavbar />
      <div className="main">
        <div className="section text-center">
          <Container>
            <Row>
              <Col className="ml-auto mr-auto" md="8">
                <h5 className="description">
                  <img src={process.env.PUBLIC_URL + "img/right.png"} />
                  얌얌키트는 언제나 최고의 제품만을 고집합니다. <br />
                  얌얌이 찾아내고 직접 맛본 후 까다롭게 엄선해서 보내드리는
                  제품으로 <br /> 맛의 차이를 직접 느껴보세요.
                  <img src={process.env.PUBLIC_URL + "img/left.png"} />
                </h5>
                <br />
                <h2
                  className="title"
                  style={{ fontFamily: "Black Han Sans, sans-serif" }}
                >
                  얌얌 맛있는 밀키트!
                </h2>
                <br />
              </Col>
            </Row>
            <br />
            <br />
            <Row>
              <Col md="4">
                <div className="info">
                  <div>
                    <img
                      src={process.env.PUBLIC_URL + "img/steak.jpg"}
                      width="280"
                      height="250"
                      alt="스테이크"
                    />
                  </div>
                  <div className="description">
                    <h4 className="info-title">토마호크 스테이크</h4>
                    <p>고마블 스테이크 550g</p>
                    <h5 style={{ fontFamily: "Black Han Sans, sans-serif" }}>
                      44,820원
                    </h5>
                    <Button className="btn-link" color="info" href="#pablo">
                      더보기
                    </Button>
                  </div>
                </div>
              </Col>
              <Col md="4">
                <div className="info">
                  <div>
                    <img
                      src={process.env.PUBLIC_URL + "img/spaghetti.jpg"}
                      width="280"
                      height="250"
                      alt="스파게티"
                    />
                  </div>
                  <div className="description">
                    <h4 className="info-title">스파이시 봉골레</h4>
                    <p>맛있게 매운 국민 파스타(2인분)</p>
                    <h5 style={{ fontFamily: "Black Han Sans, sans-serif" }}>
                      12,900원
                    </h5>
                    <Button className="btn-link" color="info" href="#pablo">
                      더보기
                    </Button>
                  </div>
                </div>
              </Col>
              <Col md="4">
                <div className="info">
                  <div>
                    <img
                      src={process.env.PUBLIC_URL + "img/schoolfood.jpg"}
                      width="280"
                      height="250"
                      alt="분식"
                    />
                  </div>
                  <div className="description">
                    <h4 className="info-title">진어전 가마보꼬 국물떡볶이</h4>
                    <p>국물떡볶이 2종(매콤한맛/짜장맛)</p>
                    <h5 style={{ fontFamily: "Black Han Sans, sans-serif" }}>
                      2,900원
                    </h5>
                    <Button className="btn-link" color="info" href="#pablo">
                      더보기
                    </Button>
                  </div>
                </div>
              </Col>
            </Row>
          </Container>
          <Container>
            <Row></Row>
            <br />
            <br />
            <Row>
              <Col md="4">
                <div className="info">
                  <div>
                    <img
                      src={process.env.PUBLIC_URL + "img/fish.jpg"}
                      width="280"
                      height="250"
                      alt="알탕"
                    />
                  </div>
                  <div className="description">
                    <h4 className="info-title">가득찬 알탕</h4>
                    <p>속이 꽉 찬 명란과 통통한 대구 곤이(2인분)</p>
                    <h5 style={{ fontFamily: "Black Han Sans, sans-serif" }}>
                      12,300원
                    </h5>
                    <Button className="btn-link" color="info" href="#pablo">
                      더보기
                    </Button>
                  </div>
                </div>
              </Col>
              <Col md="4">
                <div className="info">
                  <div>
                    <img
                      src={process.env.PUBLIC_URL + "img/risotto.jpg"}
                      width="280"
                      height="250"
                      alt="리조또"
                    />
                  </div>
                  <div className="description">
                    <h4 className="info-title">트러플오일 버섯크림 리조또</h4>
                    <p>트러플과 갈릭버터라이스 향이 가득(1인분)</p>
                    <h5 style={{ fontFamily: "Black Han Sans, sans-serif" }}>
                      7,350원
                    </h5>
                    <Button className="btn-link" color="info" href="#pablo">
                      더보기
                    </Button>
                  </div>
                </div>
              </Col>
              <Col md="4">
                <div className="info">
                  <div>
                    <img
                      src={process.env.PUBLIC_URL + "img/tteokbokki.jpg"}
                      width="280"
                      height="250"
                      alt="떡볶이"
                    />
                  </div>
                  <div className="description">
                    <h4 className="info-title">차돌 즉석 떡볶이</h4>
                    <p>쫄깃한 떡과 차돌의 만남(2인분)</p>
                    <h5 style={{ fontFamily: "Black Han Sans, sans-serif" }}>
                      13,900원
                    </h5>
                    <Button className="btn-link" color="info" href="#pablo">
                      더보기
                    </Button>
                  </div>
                </div>
              </Col>
            </Row>
          </Container>
        </div>
      </div>
      <DemoFooter />
    </>
  );
}

export default LandingPage;
