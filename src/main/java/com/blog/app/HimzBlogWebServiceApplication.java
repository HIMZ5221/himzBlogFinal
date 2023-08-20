package com.blog.app;

import com.blog.app.board.service.BoardService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.blog.app.**.mapper")
public class HimzBlogWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HimzBlogWebServiceApplication.class, args);
	}

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String login1(Model model) {
		int boardCount = boardService.getBoardCount();
		model.addAttribute("boardCount", boardCount);

		return "/board/view/inform.html";
	}
	@GetMapping("/login")
	public String login2() {
		return "login";
	}
}
