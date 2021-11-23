package com.project.yumyum.security.oauth2;


/*
1. OAuth2 프로토콜은 CSRF 공격을 방지하기 위해 state 매개변수 사용을 권장함
2. 인증 중 애플리케이션은 인증 요청에서 이 매개변수를 전송하고, OAuth2 공급자는 OAuth2 콜백에서 변경되지 않는 이 매개변수를 리턴함
3. 응용 프로그램은 OAuth2 공급자에서 반환된 state 매개변수의 값을 초기에 보낸 값과 비교. 일치하지 않으면 인증요청 거부
4. OAuth2 공급자에서 반환된 상태와 비교할 수 있도록 state 매개 변수를 어딘가에 저장해야함
-> 단기(short-lived) 쿠키에 상태와 redirect-uri를 저장함.
해당 클래스가 인증 요청을 쿠키에 저장하고 검색하는 기능 제공
*/

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.project.yumyum.util.CookieUtils;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpCookieOAuth2AuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
    public static final String OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request";
    public static final String REDIRECT_URI_PARAM_COOKIE_NAME = "redirect_uri";
    private static final int cookieExpireSeconds = 180;

    /** cookie 에 저장되어있던 authorizationRequest 들을 가져온다.
     *  authorizationUri, authorizationGrantType, responseType, clientId, redirectUri, scopes, additionalParameters */
    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        return CookieUtils.getCookie(request, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME)
                .map(cookie -> CookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class))
                .orElse(null);
    }

    /** 플랫폼으로 보내기 위한 Request를 `oauth2_auth_request` 라는  cookie 에 저장 한다 .
     * authorizationUri, authorizationGrantType, responseType, clientId, redirectUri, scopes, additionalParameters */
    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request, HttpServletResponse response) {
        if (authorizationRequest == null) {
            removeAuthorizationRequest(request, response);
            return;
        }

        CookieUtils.addCookie(response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME, CookieUtils.serialize(authorizationRequest), cookieExpireSeconds);

        /**
         * http://localhost:8080/oauth2/authorize/naver?redirect_uri=http://localhost:3000/oauth/redirect 로 요청 받았을 때
         * http://localhost:3000/oauth/redirect 를 가져온다
         * 그리고 존재하는 경우 cookie 에 넣어준다
         */
        String redirectUriAfterLogin = request.getParameter(REDIRECT_URI_PARAM_COOKIE_NAME);
        if (StringUtils.isNotBlank(redirectUriAfterLogin)) {
            CookieUtils.addCookie(response, REDIRECT_URI_PARAM_COOKIE_NAME, redirectUriAfterLogin, cookieExpireSeconds);
        }
    }

    /** remove 를 재정의 해서 cookie 를 가져오고 remove 는 successHandler 또는 failureHandler 에서 할 수 있도록 한다 */
    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request) {
        return this.loadAuthorizationRequest(request);
    }

    /**
     * 사용자 정보를 다 가지고 온 뒤 이제 리다이렉트를 하면 기존에 남아있던 쿠키들을 제거해주기 위해 사용된다
     *  OAuth2AuthorizationRequest 와 클라이언트에서 파리미터로 요청한 redirect_uri 가 된다
     * */
    public void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
        CookieUtils.deleteCookie(request, response, REDIRECT_URI_PARAM_COOKIE_NAME);
    }
}
