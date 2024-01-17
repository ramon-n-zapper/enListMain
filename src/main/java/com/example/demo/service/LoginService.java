package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面
 * 
 * @auther ramon
 *
 */
@Service
@RequiredArgsConstructor
public class LoginService {

	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository repository;
	
	/**
	 *  ユーザー情報テーブル 主キー検索
	 *  
	 * @param loginld ログインID
	 * @return ユーザー情報テーブルを主キー検索した結果(1件)
	 */
	public Optional<UserInfo> searchUserById(String loginld) {
		return repository.findById(loginld);
	}
}
