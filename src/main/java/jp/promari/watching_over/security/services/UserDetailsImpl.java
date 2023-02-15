package jp.promari.watching_over.security.services;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.promari.watching_over.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * ユーザー情報を取得するクラス
 * (ユーザー情報は UserDetails インターフェースを実装したクラスで作成)
 */
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    /*
     * @JsonIgnore　//指定したプロパティをシリアライズ、デシリアライズの対象外
     * シリアライズ：インスタンスから JSON へ変換すること
     * デシリアライズ：JSON からインスタンスへ変換すること
     */
    @JsonIgnore
    private String password;

    //ユーザーの権限ひとつのユニットに集めたオブジェクト
    private Collection<? extends GrantedAuthority> authorities;

    //コンストラクタ
    public UserDetailsImpl(Long id, String username, String email, String password,
        Collection<? extends GrantedAuthority> authorities) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.authorities = authorities;
    }

    //UserDetailsImplのコンストラクタに渡すメソッド
    public static UserDetailsImpl build(User user) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("TEST");
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(authority);

        // List<GrantedAuthority> authorities = auth.getAuthorities().stream()
        //                             .map(GrantedAuthority::getAuthority)
        //                             .collect(joining("\n  ")));
        // List<GrantedAuthority> authorities = user.getRoles().stream()
        //     .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        //     .collect(Collectors.toList());

        return new UserDetailsImpl(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getPassword(),
            authorityList);
      }

    //「GrantedAuthorityのインスタンスが表す権限を文字列で表現したもの」を返す
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() { //ユーザアカウントが認証期限切れしていないか
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //ユーザアカウントがロックしていないか
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //ユーザアカウントの資格が認証期限切れしていないか
        return true;
    }

    @Override
    public boolean isEnabled() { //ユーザアカウントが無効
        return true;
    }

    /*
     * equalsはインスタンスに同じかを「聞く」メソッド
     */
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        //equalsで比較判定を行いJVMで判断する。（true/falseで返す）
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
