package org.Instrgram.config.auth;

import org.Instrgram.entity.User;
import org.Instrgram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/*
 * 회원가입할 때 USER권한을 줘야 접근권한이 생겨서 로그인을 할 수 있다.
 */

@RequiredArgsConstructor
@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public void join(User user) {

		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);

		System.out.print("encPassword !!!!!:::::::" + encPassword);
		user.setPassword(encPassword);
		user.setRole("USER");
		userRepository.save(user);
	}

}