package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 Controller
 * 
 * @auther ramon
 *
 */
@Controller
@RequiredArgsConstructor
public class LoginController {
	
	/**ログイン画面 Service*/
	private final LoginService service;
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		
		return "login";
	}
	
	/**
	 * ログイン：formに入力されたパスワードとDAO(repository)から取ってきたパスワードを比較、出力
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		Optional<UserInfo> userInfo = service.searchUserById(form.getLoginId());
		boolean isCorrectUserAuth = userInfo.isPresent()
				&& form.getPassword().equals(userInfo.get().getPassword());
		if(isCorrectUserAuth) {
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "ログインIDとパスワードが間違っています");
			return "login";
		}
	}
}
