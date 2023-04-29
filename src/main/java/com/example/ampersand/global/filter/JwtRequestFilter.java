package com.example.ampersand.global.filter;

import com.example.ampersand.global.security.exception.TokenNotValidException;
import com.example.ampersand.global.security.jwt.TokenProvider;
import com.example.ampersand.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;

    public void registerSecurityContext(HttpServletRequest request, String email) {
        UsernamePasswordAuthenticationToken authenticationToken = tokenProvider.authenticationToken(email);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader("Authorization");

        if (!Objects.isNull(accessToken)) {
            tokenProvider.extractAllClaims(accessToken, jwtProperties.getAccessSecret());
            if (!tokenProvider.getTokenType(accessToken, jwtProperties.getAccessSecret()).equals("ACCESS_TOKEN")) {
                throw new TokenNotValidException("토큰이 유효하지 않습니다.");
            }

            String email = tokenProvider.getUserEmail(accessToken, jwtProperties.getAccessSecret());
            registerSecurityContext(request, email);
        }
        filterChain.doFilter(request, response);
    }
}
