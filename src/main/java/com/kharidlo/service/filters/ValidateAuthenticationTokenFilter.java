package com.kharidlo.service.filters;

import com.kharidlo.service.authentication.repository.UserAuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/order")
public class ValidateAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    UserAuthenticationTokenRepository authenticationTokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        String authToken = httpServletRequest.getHeader("Authorization");

        if (Objects.isNull(authenticationTokenRepository.findAuthTokenByToken(authToken))) {
            httpServletResponse.sendError(403, "invalid Token");
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
