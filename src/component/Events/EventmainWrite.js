import React from "react";

// reactstrap components
import { Button, Container, Row, Col } from "reactstrap";

import { Link } from "react-router-dom";

import "assets/css/EventNavbar.css";

import box from "assets/img/event/box.jpg";
import price from "assets/img/event/price.jpg";

function EventmainWrite() {
  document.documentElement.classList.remove("nav-open");
  React.useEffect(() => {
    document.body.classList.add("profile-page");
    return function cleanup() {
      document.body.classList.remove("profile-page");
    };
  });

  return (
    <>
      <div>
        <Container>
          <Row className="text-center">
            <Col className="ml-auto mr-auto" md="10" id="eventcolor">
              <div>
                <h5>
                  <h6>
                    <img src={price} />
                    우리집 메인 쉐프가 될 수 있는 철호의 기회! <br />
                    지금 가입하면 얌얌키트 밀키트가 990원?! <br />
                    놓칠 수 없쥐~~
                  </h6>
                </h5>
              </div>
              <br />
              <Link to="/epopup">
                <Button className="btn-round">Event 자세히 보기</Button>
              </Link>

              <br />

              <div>
                <h5>
                  <h6>
                    <img src={box} />
                    다음주 얌얌키트에 새로운 밀키트가?! <br />
                    맞추신 분들에겐 특별한 혜택이! <br />
                    어떤 밀키트일까~~ 알아맞춰보세용
                  </h6>
                </h5>
              </div>
              <br />
              <Link to="/epopup">
                <Button className="btn-round">Event 자세히 보기</Button>
              </Link>
            </Col>
          </Row>
        </Container>
      </div>
    </>
  );
}

export default EventmainWrite;
