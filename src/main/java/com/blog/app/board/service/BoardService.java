package com.blog.app.board.service;

import com.blog.app.vo.BoardVO;

import java.util.List;

public interface BoardService  {

    public int saveBoard(BoardVO BoardVO);

    List<BoardVO> getBoardList(BoardVO boardVO);

    int getBoardCount();

    int updateHit(BoardVO boardVO);
}
