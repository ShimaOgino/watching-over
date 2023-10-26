package jp.promari.watching_over.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.promari.watching_over.repository.UserRepository;
import jp.promari.watching_over.security.jwt.JwtUtils;

@Controller // HTTP Response Bodyが生成される方式
// @RequestMapping("/api/auth") // リクエストURLに対して、どのメソッドが処理を実行するか定義する
public class AuthController {
    // @Autowired newを記述しなくても他のクラスを呼び出すことができる
    // AuthenticationManager 実装クラスで認証判定を行うインターフェース
    // @Autowired
    // AuthenticationManager authenticationManager;

    // Repositoryのインターフェースとやりとりをし、(Repository内)実体クラスの処理を行う
    @Autowired
    UserRepository userRepository; // ユーザー情報

    // PasswordEncoder ソルト + ストレッチングされたハッシュ値が生成でき、平文パスワードとの照合も容易にできる
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // /* 引数のloginRequestの情報をもとに処理を行う */
    // @PostMapping("/signin") // メソッドとPOSTの処理を行うURLを紐づける
    // public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    //     /**
    //      * 認証可否の処理
    //      * AuthenticationManagerの実装クラスにProviderManagerを持ち、
    //      * 実際にパスワード一致などの判定を行うAuthenticationProviderを配列で持っており、
    //      * 各Providerのauthenticateメソッドを呼び、認証判定を行います。
    //      */
    //     Authentication authentication = authenticationManager
    //             .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
    //                     loginRequest.getPassword()));

    //     // コンテキストに認証情報を設定するメソッドです。（ログイン認証OKであることを表す。）
    //     SecurityContextHolder.getContext().setAuthentication(authentication);

    //     // ユーザー情報の照合
    //     UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    //     // SameSiteを明示する
    //     ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    //     // SpringBootの特定の応答にヘッダーとボディーを返す
    //     return ResponseEntity.ok()
    //             .header(HttpHeaders.SET_COOKIE, jwtCookie.toString()) // header 約束事を書く部分
    //             .body(new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail()));
    // }

    // /* 引数のsignUpRequestの情報をもとに処理を行う */
    // @PostMapping("/signup")
    // public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    //     // すでに名前が使われていた場合
    //     if (userRepository.existsByUsername(signUpRequest.getUsername())) {
    //         return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    //     }

    //     // すでにEmailが使われていた場合
    //     if (userRepository.existsByEmail(signUpRequest.getEmail())) {
    //         return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    //     }

    //     // -------------------------------------------------------------
    //     // Create new user's account
    //     // -------------------------------------------------------------
    //     User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
    //             encoder.encode(signUpRequest.getPassword()));
    //     // java.util.Setインターフェースは重複のない要素の集まり
    //     userRepository.save(user);

    //     return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    // }

    // // signout処理
    // @PostMapping("/signout")
    // public ResponseEntity<?> logoutUser(@Valid @RequestBody LogoutRequest logoutRequest) {

    //     return ResponseEntity.ok()
    //             .body(new MessageResponse("You've been signed out!"));
    // }
}
