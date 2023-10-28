// package jp.promari.watching_over.security.jwt;



// import java.nio.charset.StandardCharsets;
// import java.util.Base64;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class WebUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

// 	@Override
// 	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
// 			throws AuthenticationException {

// 		String authorization = req.getHeader("Authorization");

//         String authHeaderValue = authorization.substring("Basic ".length()).trim();
//         byte[] decodedBytes = Base64.getDecoder().decode(authHeaderValue);
//         String userAndPass = new String(decodedBytes, StandardCharsets.UTF_8);

// 		String user = userAndPass.substring(0,userAndPass.indexOf(":"));
// 		String password = userAndPass.substring((userAndPass.indexOf(":")+1));

// 		if(user == null) {
// 			user = "";
// 		}

// 		if(password == null) {
// 			password = "";
// 		}

//         // トークンの作成
//         UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user, password);

//         setDetails(req, authRequest);
//         return this.getAuthenticationManager().authenticate(authRequest);
// 	}
// }
