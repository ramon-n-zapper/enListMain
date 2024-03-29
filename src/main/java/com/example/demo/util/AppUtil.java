package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通処理クラス
 * 
 * @auther ramon
 *
 */
public class AppUtil {
	
	/**
	 * メッセージIDから、プロパティファイルに定義されているメッセージを取得する。
	 * 
	 * <p>取得したメッセージ内で置換が必要な個所がある場合は<br>
	 * 引数の置換文字群を使って置換を行う。
	 * 
	 * @param messageSource メッセージソース
	 * @param messageId メッセージID
	 * @param params 置換文字群
	 * @return プロパティファイルから取得したメッセージ
	 */
	public static String getMessage(MessageSource messageSource, String key, Object...params) {
		return messageSource.getMessage(key, params, Locale.JAPAN);
		
	}

}
