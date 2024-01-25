package com.example.demo.form;

import lombok.Data;

/**
 * ユーザー登録画面 form
 * 
 * @auther ramon
 *
 */
@Data
public class SignupForm {

	/** ログイン画面 */
	private String loginId;
	
	/** パスワード	 */
	private String password;
}
