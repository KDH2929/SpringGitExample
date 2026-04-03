package com.example.demo.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.model.BoardCategory;

@Mapper
public interface IBoardCategoryRepository {
	int selectMaxCategoryId();

	List<BoardCategory> selectAllCategory();

	void insertNewCategory(BoardCategory boardCategory);

	void updateCategory(BoardCategory boardCategory);

	void deleteCategory(int categoryId);
}
