package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WordEntity;

/**
 * 単語情報テーブルRepositoryクラス
 * 
 * @auther ramon
 *
 */
public interface WordRepository extends JpaRepository<WordEntity, Long>{

}
