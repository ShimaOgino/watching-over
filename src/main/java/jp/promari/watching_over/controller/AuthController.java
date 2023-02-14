// package jp.promari.watching_over.controller;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;

// import jakarta.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.ResponseCookie;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import jp.promari.watching_over.models.User;
// import jp.promari.watching_over.usecase.request.LoginRequest;
// import jp.promari.watching_over.usecase.request.SignupRequest;
// import jp.promari.watching_over.usecase.response.UserInfoResponse;
// import jp.promari.watching_over.usecase.response.MessageResponse;
// import jp.promari.watching_over.repository.UserRepository;
// import jp.promari.watching_over.security.jwt.JwtUtils;
// import jp.promari.watching_over.security.services.UserDetailsImpl;


// @CrossOrigin(origins = "*", maxAge = 3600)     //アクセス許可元などを指定（すべてのオリジンに許可／プリフライトリクエストの結果をキャッシュしてよい時間）
// @RestController     //HTTP Response Bodyが生成される方式
// @RequestMapping("/api/auth")     //リクエストURLに対して、どのメソッドが処理を実行するか定義する
// public class AuthController{
//     //@Autowired newを記述しなくても他のクラスを呼び出すことができる
//     //AuthenticationManager　実装クラスで認証判定を行うインターフェース
//     @Autowired
//     AuthenticationManager  authenticationManager;

//     //Repositoryのインターフェースとやりとりをし、(Repository内)実体クラスの処理を行う
//     @Autowired
//     UserRepository userRepository; //ユーザー情報

//     //PasswordEncoder ソルト + ストレッチングされたハッシュ値が生成でき、平文パスワードとの照合も容易にできる
//     @Autowired
//     PasswordEncoder encoder;

//     //Jwt 属性情報（Claim）をJSONデータ構造で表現したトークンの仕様
//     @Autowired
//     JwtUtils jwtUtils;

//     /* 引数のloginRequestの情報をもとに処理を行う */
//     @PostMapping("/signin") //メソッドとPOSTの処理を行うURLを紐づける
//     public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//         /**
//          * 認証可否の処理
//          * AuthenticationManagerの実装クラスにProviderManagerを持ち、
//          * 実際にパスワード一致などの判定を行うAuthenticationProviderを配列で持っており、
//          * 各Providerのauthenticateメソッドを呼び、認証判定を行います。
//         */
//         Authentication authentication = authenticationManager
//             .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

//         //コンテキストに認証情報を設定するメソッドです。（ログイン認証OKであることを表す。）
//         SecurityContextHolder.getContext().setAuthentication(authentication);

//         //ユーザー情報の照合
//         UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

//         //SameSiteを明示する
//         ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

//         // /**
//         //  * getAuthoritiesのリストをstreamに変換
//         //  * mapメソッドでStreamに格納されているitemを呼び出し、
//         //  * ItemクラスのgetAuthorities（）を呼び出す。
//         //  * 文字列のStreamに変換する
//         //  * collectメソッドを呼び出して、SteamをListに変換している
//         //  * */
//         // List<String> roles = userDetails.getAuthorities().stream()
//         //         .map(item -> item.getAuthority())
//         //         .collect(Collectors.toList());

//         //SpringBootの特定の応答にヘッダーとボディーを返す
//         return ResponseEntity.ok()
//             .header(HttpHeaders.SET_COOKIE, jwtCookie.toString()) //header 約束事を書く部分
//             .body(new UserInfoResponse(userDetails.getId(),userDetails.getUsername(),userDetails.getEmail()));
//     }

//     /* 引数のsignUpRequestの情報をもとに処理を行う */
//     @PostMapping("/signup")
//     public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//         //すでに名前が使われていた場合
//         if(userRepository.existsByUsername(signUpRequest.getUsername())) {
//             return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//         }

//         //すでにEmailが使われていた場合
//         if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//             return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//         }

//         // -------------------------------------------------------------
//         // Create new user's account
//         // -------------------------------------------------------------
//         User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
//         //java.util.Setインターフェースは重複のない要素の集まり
//         userRepository.save(user);

//         return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//     }

//     //signout処理
//     @PostMapping("/signout")
//     public ResponseEntity<?> logoutUser() {
//         ResponseCookie cookie = jwtUtils.getClass();

//     return ResponseEntity.ok()
//         .header(HttpHeaders.SET_COOKIE, cookie.toString())
//         .body(new MessageResponse("You've been signed out!"));
//     }
// }
