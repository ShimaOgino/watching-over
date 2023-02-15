package jp.promari.watching_over.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.promari.watching_over.models.User;
import jp.promari.watching_over.repository.UserRepository;

/*
 * 認証の処理クラス
 * (ユーザー情報は UserDetails インターフェースを実装したクラスで作成)
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    //
    return UserDetailsImpl.build(user);
  }
}
