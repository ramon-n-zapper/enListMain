package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザー情報テーブルEntityクラス
 * 
 * @author ramon
 *
 */
@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

	/** ログインID */
	@Id
	@Column(name = "login_id")
	private String loginId;
	
	/** パスワード */
	private String password;
	
	/** ログイン失敗回数 */
	@Column(name = "login_failure_count")
	private int loginFailureCount = 0;
	
	/** アカウントロック日時 */
	@Column(name = "account_locked_time")
	private LocalDateTime accountLockedTime;
	
	/** アカウントが利用可能か(true:利用可能) */
	private boolean isDisabled;
	
	/**
	 * ログイン失敗回数をインクリメントします。
	 * 
	 * @return ログイン失敗回数がインクリメントされた、自身のインスタンス
	 */
	public UserInfo incrementLoginFailureCount() {
		return new UserInfo(loginId, password, ++loginFailureCount, accountLockedTime, isDisabled);
	}
	
	/**
	 * ログイン失敗情報をリセットします。
	 * 
	 * @return ログイン失敗情報がリセットされた、自身のインスタンス
	 */
	public UserInfo resetLoginFailureInfo() {
		return new UserInfo(loginId, password, 0, null, isDisabled);
	}
	
	/**
	 * ログイン失敗回数、アカウントロック日時を更新し、アカウントロック状態に更新します。
	 * 
	 * @return ログイン失敗回数、アカウントロック日時が更新された、自身のインスタンス
	 */
	public UserInfo updateAccountLocked() {
		return new UserInfo(loginId, password, 0, LocalDateTime.now(), isDisabled);
	}
}
