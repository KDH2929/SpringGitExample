package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.model.BoardCategory;

public interface IBoardCategoryService {
	List<BoardCategory> selectAllCategory();

	void insertNewCategory(BoardCategory boardCategory);

	void updateCategory(BoardCategory boardCategory);

	void deleteCategory(int categoryId);
}
