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
 * ユーザー情報テーブル Entity
 * @auther ramon
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
	 * ログイン失敗回数をインクリメントする
	 * 
	 * @return ログイン失敗回数がインクリメントされたUserInfo
	 */
	public UserInfo incrementLoginFailureCount() {
		return new UserInfo(loginId, password, ++loginFailureCount, accountLockedTime, isDisabled);
	}
	
	/**
	 * ログイン失敗情報をリセットする
	 * 
	 * @return ログイン失敗回数がリセットされたUserInfo
	 */
	public UserInfo resetLoginFailureInfo() {
		return new UserInfo(loginId, password, 0, null, isDisabled);
	}
	
	/**
	 * アカウントロック状態に更新する
	 * 
	 * @return ログイン失敗回数、アカウントロック日時が更新されたUserInfo
	 */
	public UserInfo updateAccountLocked() {
		return new UserInfo(loginId, password, 0, LocalDateTime.now(), isDisabled);
	}
}
