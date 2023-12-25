package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordController {

	private WordRepository wordRepository;
	
	//コンストラクタ、コンストラクタインジェクションなので@Autowiredは必要なし
	public WordController(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}
	
	//DB内の情報を全件検索、index.htmlにて表示
	@GetMapping("/")
	public String displayWords(Model model) {
		//ここでDB内の情報をfindAllにて全件検索、そしてwordsクラスに格納、
		List<WordEntity> words = wordRepository.findAll();
		model.addAttribute("words", words);
		return "index.html";
	}
	
	//単語追加のためのadd.htmlを表示
	@GetMapping("/add")
	public String showAddPage() {
		return "add.html";
	}
	
	//単語追加処理
	@PostMapping("/addNewWord")
	public String addWord(WordEntity word) {

	    // 単語を保存
	    wordRepository.save(word);

	    // リダイレクト
	    return "redirect:/";
	}
	
	//編集ページの表示と、idに紐づけられている編集対象の単語表示
	@GetMapping("/edit")
	public String editWord(Model model, @RequestParam(name = "id") Long id) {

	    // 単語を取得
	    WordEntity word = wordRepository.findById(id).orElse(null);

	    // 単語をモデルに追加
	    model.addAttribute("word", word);

	    // 編集ページを表示
	    return "edit.html";
	}

	//編集対象の単語更新
	@PostMapping("/updateNewWord")
	public String updateWord(WordEntity word) {

	    // 単語を更新
	    wordRepository.save(word);

	    // リダイレクト
	    return "redirect:/";
	}

	//単語削除
	@GetMapping("/delete")
	public String deleteWord(@RequestParam(name = "id") Long id) {
		
		WordEntity word = wordRepository.findById(id).orElse(null);
		
		wordRepository.delete(word);
		
		return "redirect:/";
	}
}
