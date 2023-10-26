package jp.promari.watching_over.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @Entity JPAのエンティティであることを示す
 * @Table エンティティに対応するテーブル名を指定("users")
 *    @UniqueConstraint テーブルに対して一意(重複しない)の制約を定義する
 *    columnNamesアレイは論理カラム名を参照する(usernameとemailは重複しません)
 */
@Entity
@Table(name = "users", uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class User {
    @Id  //主キーであることを示す
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //値を自動生成する(データベースのidentity列を利用して，プライマリキー値を生成します。)
    private Long id;

    @NotBlank  //文字列がnullでないかつ空文字でないことを検証する。
    @Size(max=20)  //文字数または配列の要素数が範囲内であることを検証する。
    private String username;

    @NotBlank
    @Size(max=50)
    @Email  //文字列が正しいメールアドレス（RFC2822）であることを検証する。
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
