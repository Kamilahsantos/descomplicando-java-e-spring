package com.linuxtips.jwtrefreshtoken.jwt;


import com.linuxtips.jwtrefreshtoken.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Filter extends OncePerRequestFilter {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private Util jwtUtil;


    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authorization = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwtToken = authorization.substring(7);
            username = jwtUtil.getUsername(jwtToken);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userAuthenticationService.loadUserByUsername(username);

            if (jwtUtil.verifyToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    }

