package jp.promari.watching_over.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.promari.watching_over.models.User;

//java.util.Optional 「nullかもしれない値」を上手に取り扱うためのクラス
//JpaRepository 基本的なCRUD操作を扱えるようなメソッドが用意されています。
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //usernameを条件として検索し、レコードを取得する
    Optional<User>  findByUsername(String username);

    //usernameがある(true)かない(false)か
    Boolean existsByUsername(String username);

    //emailがある(true)かない(false)か
    Boolean existsByEmail(String email);
}
