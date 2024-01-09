package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "words")
public class WordEntity {
	
	@Id
	@Setter
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Setter
	@Getter
	private String english;
	
	@Setter
	@Getter
	private String japanese;
	
	public WordEntity() {
		//デフォルトコンストラクタ
	}
	
	public WordEntity(String english, String japanese) {
		this.english = english;
		this.japanese = japanese;
	}
}
