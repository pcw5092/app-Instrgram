package org.Instrgram.config.auth;

import org.Instrgram.entity.User;
import org.Instrgram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("로그인 진행중");
		
		User principal = userRepository.findByUsername(username);
		
		if (principal == null) {			
			return null;
		} else {
			// SecuriryContextHolder 폴더 내 Authentication 객체 내부에 담김
			return new PrincipalDetails(principal); 
		}
	}
}