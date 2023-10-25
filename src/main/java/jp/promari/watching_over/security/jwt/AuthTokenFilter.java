// package jp.promari.watching_over.security.jwt;

// import java.io.IOException;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.util.StringUtils;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jp.promari.watching_over.security.services.UserDetailsServiceImpl;

// @Component
// public class AuthTokenFilter extends OncePerRequestFilter {

//     @Autowired
//     private UserDetailsServiceImpl userDetailsService;

//     @Autowired
//     JwtUtils jwtUtils;

//     private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         // try {
//         //     String jwt = parseJwt(request);
//         //     String requestURL = request.getRequestURI();

//         //     if (!requestURL.endsWith("/signup")) {
//         //         if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
//         //             String username = jwtUtils.getUserNameFromJwtToken(jwt);

//         //             UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//         //             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//         //                     userDetails,
//         //                     null,
//         //                     userDetails.getAuthorities());
//         //             authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//         //             SecurityContextHolder.getContext().setAuthentication(authentication);
//         //         }
//         //     }
//         // } catch (Exception e) {
//         //     logger.error("Cannot set user authentication: {}", e);
//         // }

//         //filterChain.doFilter(request, response);
//     }

//     private String parseJwt(HttpServletRequest request) {
//         String headerAuth = request.getHeader("Authorization");

//         if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
//             return headerAuth.substring(7, headerAuth.length());
//         }

//         return null;
//     }
// }
