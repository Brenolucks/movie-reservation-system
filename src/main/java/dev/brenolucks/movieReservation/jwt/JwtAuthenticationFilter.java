package dev.brenolucks.movieReservation.jwt;

import dev.brenolucks.movieReservation.service.users.UserDetailsServiceImplementation;
import dev.brenolucks.movieReservation.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    public JwtAuthenticationFilter(JwtUtils jwtUtils, UserDetailsServiceImplementation userDetailsServiceImplementation) {
        this.jwtUtils = jwtUtils;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = jwtUtils.extractToken(request);

        if(token != null && jwtUtils.tokenValid(token)) {
            var username =jwtUtils.getUsernameByToken(token);

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var userDetails = userDetailsServiceImplementation.loadUserByUsername(username);
                Collection<? extends GrantedAuthority> authorities = jwtUtils.extractAuthorities(token);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null,
                        authorities);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);

    }
}
