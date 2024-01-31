package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

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
	@Length(min = 8, max = 20)
	private String loginId;
	
	/** パスワード	 */
	@Length(min = 8, max = 20)
	private String password;
}
