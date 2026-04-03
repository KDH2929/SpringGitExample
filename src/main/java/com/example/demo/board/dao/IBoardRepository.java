package com.example.demo.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardUploadFile;

// 스프링프레임워크는 설정파일에서 Mapper-Scan을 수행하나
// 스프링부트는 @Mapper Annotation을 추가
@Mapper
public interface IBoardRepository {
	
	// 이거도 사실은 인터페이스 함수일 뿐이다.  MyBatis 쿼리문과 맵핑되는
	List<Board> selectArticleListByCategory(@Param("categoryId") int categoryId, 
											@Param("start") int start, 
											@Param("end") int end);
											
	Board selectArticle(int boardId);
	void updateReadCount(int boardId);
	int selectMaxArticleNo();
	int selectMaxFileId();
	void insertArticle(Board board);
	
	void insertFileData(BoardUploadFile file);
	BoardUploadFile getFile(int fileId);
	
	void updateReplyNumber(@Param("masterId") int masterId,
						   @Param("replyNumber") int replyNumber);
	
	void replyArticle(Board boardId);
	
	String getPassword(int boardId);
	void updateArticle(Board board);
	void updateFileData(BoardUploadFile file);
	Board selectDeleteArticle(int boardId);
	void deleteFileData(int boardId);
	void deleteArticleByBoardId(int boardId);
	void deleteReplyFileData(int boardId);
	void deleteArticleByMasterId(int boardId);
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(int categoryId);
	int selectTotalArticleCountByKeyword(String keyword);
	
	List<Board> searchListByContentKeyword(@Param("keyword") String keyword,
										   @Param("start") int start,
										   @Param("end") int end);
	
	
}
