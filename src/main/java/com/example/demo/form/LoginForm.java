package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * ログイン画面formクラス
 * 
 * @auther ramon
 *
 */
@Data
public class LoginForm {

	/** ログイン画面 */
	@Length(min = 8, max = 20)
	private String loginId;
	
	/** パスワード	 */
	@Length(min = 8, max = 20)
	private String password;
}
