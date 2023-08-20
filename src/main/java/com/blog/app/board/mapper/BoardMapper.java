package com.blog.app.board.mapper;

import com.blog.app.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{

    public int saveBoard(BoardVO BoardVO);

    List<BoardVO> getBoardList(BoardVO boardVO);

    int getBoardCount();

    int updateHit(BoardVO boardVO);
}
