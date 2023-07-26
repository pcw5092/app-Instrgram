package org.Instrgram.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.Instrgram.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/*
 * 시큐리티에 필요한 부분 설정
 * UserDetails에 필요한 메서드 자동으로 만들어주고 return 값은 true로 변경해준다.
 * 
 */

@Data
public class PrincipalDetails implements UserDetails {

	private User user;

	public PrincipalDetails(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		// 해당 User의 권한을 리턴하는 곳 getRole을 바로 return 할수 없음
		Collection<GrantedAuthority> collectors = new ArrayList<>(); // collectors에 권한 부여
		collectors.add(() -> "ROLE_" + user.getRole().toString()); // collectors 에 리턴되서 들어간다.
		// collectors 에 GrantedAuthority타입을 넣어줘야한다.
		return collectors;
	}
}