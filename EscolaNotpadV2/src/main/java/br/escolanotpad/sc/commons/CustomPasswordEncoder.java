package br.escolanotpad.sc.commons;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return Utils.senhaToSha256(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodePassword) {
		return Utils.senhaToSha256(rawPassword.toString()).equals(encodePassword);
	}
	

}
