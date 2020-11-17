package kr.or.ddit.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceI;

@RequestMapping("/board")
@Controller
public class boardController {
	private static final Logger logger = LoggerFactory.getLogger(boardController.class);

	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	@RequestMapping("/boardList")
	public String list(Model model) {
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		return "board/board";
	}
	
	@RequestMapping("/createBoard")
	public String createBoard(String board_title, Model model) {
		logger.debug("board_title : {}", board_title);
		int cnt = boardService.createBoard(board_title);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVo boardVo, Model model) {
		logger.debug("board_title : {}", boardVo);
		int cnt = boardService.updateBoard(boardVo);
		logger.debug("cnt : {}", cnt);
		return "redirect:/board/boardList";
	}
	
	
	
	
}
