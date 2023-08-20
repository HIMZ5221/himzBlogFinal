package com.blog.app.board;

import com.blog.app.board.service.BoardService;
import com.blog.app.vo.BoardVO;
import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board/")
public class BoardController {


    @Autowired private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("inform")
    public String informPage(Model model){

        int boardCount = boardService.getBoardCount();
        model.addAttribute("boardCount", boardCount);

        return "/board/view/inform.html";
    }

    @PostMapping("freeBoard")
    public String viewFreeBoardPage(@RequestParam String bno, Model model){

        System.out.println("클릭된 글 : " + bno);
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(bno);

        List<BoardVO> result = boardService.getBoardList(boardVO);
        System.out.println(result);
        // 일단은 살짝 하드코딩으로 해결한다.
        if (result.size()>0){
            int result2 = boardService.updateHit(boardVO);
        }

        model.addAttribute( "response", result);

        return "/board/view/freeBoardView.html";
    }

    @GetMapping("create")
    public String createPage(Model model){
        model.addAttribute("data", "Hallo!");

        return "/board/create/createBoard.html";
    }





    @RequestMapping("/getBoardList")
    @ResponseBody
    public Map<String, Object> getBoardList(@RequestBody BoardVO BoardVO, Model model){
        System.out.println("BoardController_getBoardList");

        int boardCount = boardService.getBoardCount();
        List<BoardVO> resultList = boardService.getBoardList(BoardVO);
        System.out.println(resultList);

        Map<String, Object> response = new HashMap<>();
        response.put("res", "success");
        response.put("resultList", resultList);
        response.put("boardCount", boardCount);
        return response;
    }



    @RequestMapping("/saveBoard")
    @ResponseBody
    public Map<String, String> saveBoard(@RequestBody BoardVO BoardVO, Model model){
        System.out.println("BoardController_saveBoard");

        int result = boardService.saveBoard(BoardVO);
        Map<String, String> response = new HashMap<>();

        if (result > 0){
            response.put("res", "success");
        };
        return response;
    }
}
