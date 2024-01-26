package com.example.demo.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面　Service
 * 
 * @auther ramon
 *
 */
@Service
@RequiredArgsConstructor
public class SignupService {

	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;
	
	/**
	 *  ユーザー情報テーブル 主キー検索
	 *  
	 * @param loginld ログインID
	 * @return 登録情報(ユーザー登録Entity)、既に同じユーザーIDで登録がある場合はEmpty
	 */
	public Optional<UserInfo> resistUserInfo(SignupForm form) {
		var userInfoExistedOpt = repository.findById(form.getLoginId());
		
		//既に同じユーザーIDがあるかの判別
		if (userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}
		
		var userInfo = mapper.map(form, UserInfo.class);
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		userInfo.setPassword(encodedPassword);
		
		return Optional.of(repository.save(userInfo));
	}
}
