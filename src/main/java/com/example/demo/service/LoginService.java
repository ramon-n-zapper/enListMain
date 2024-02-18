package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面Serviceクラス
 * 
 * @auther ramon
 *
 */
@Service
@RequiredArgsConstructor
public class LoginService {

	/** ユーザー情報テーブルRepository */
	private final UserInfoRepository repository;
	
	/**
	 *  入力されたIDに基づきユーザー情報テーブルから主キー検索を行います。
	 *  
	 * @param loginld ログインID
	 * @return ユーザー情報テーブルを主キー検索した結果(1件)
	 */
	public Optional<UserInfo> searchUserById(String loginld) {
		return repository.findById(loginld);
	}
}
