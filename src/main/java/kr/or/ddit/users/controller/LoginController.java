package kr.or.ddit.users.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.users.model.UserVo;
import kr.or.ddit.users.service.UserServiceI;

@RequestMapping("/login")
@Controller
public class LoginController {
private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name = "userService")
	private UserServiceI userService;
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	@RequestMapping(path="/userLogin", method=RequestMethod.GET) 
	public String getView() {
		logger.debug("LoginController.getView()");
		return "user/userLogin";
	}
	
	@RequestMapping(path="/process", params = {"user_id"})
	public String process(String user_id, String user_pass, UserVo dbMemberVo, 
						  @RequestBody String body,
						  HttpSession session, Model model) {
		logger.debug("LoginController.process() {} / {} / {}", user_id, user_pass, dbMemberVo);
		logger.debug("user_id : {}", user_id);
		
		logger.debug("body : {}", body);
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		
		UserVo userVo = userService.getUser(user_id);
		logger.debug("dbMemberVo : {}", dbMemberVo);
		logger.debug("userVo : {}", userVo);
		
		if ( userVo != null && dbMemberVo.getUser_pass().equals(userVo.getUser_pass())) {
			session.setAttribute("S_MEMBER", userVo);
			return "user/userMain";
		}else {
			
			return "user/userLogin";
		}
	}

}
