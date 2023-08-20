package com.blog.app.board.service;

import com.blog.app.board.mapper.BoardMapper;
import com.blog.app.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired private BoardMapper boardMapper;

    @Override
    public int saveBoard(BoardVO boardVO) {
        System.out.println("BoardServiceImpl_saveBoard");
        System.out.println(boardVO);
        return boardMapper.saveBoard(boardVO);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO boardVO) {
        System.out.println("BoardServiceImpl_getBoardList");
        System.out.println(boardVO);
        return boardMapper.getBoardList(boardVO);
    }

    @Override
    public int getBoardCount() {
        return boardMapper.getBoardCount();
    }

    @Override
    public int updateHit(BoardVO boardVO) {
        return boardMapper.updateHit(boardVO);
    }
}
