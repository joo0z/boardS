package kr.or.ddit.member.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping(path="/memberLogin", method=RequestMethod.GET) 
	public String getView() {
		logger.debug("LoginController.getView()");
		return "login/memberLogin";
	}
	
	@RequestMapping(path="/process", params = {"mem_id"})
	public String process(String mem_id, String mem_pass, MemberVo dbMemberVo, 
						  @RequestBody String body,
						  HttpSession session, Model model) {
		logger.debug("LoginController.process() {} / {} / {}", mem_id, mem_pass, dbMemberVo);
		logger.debug("mem_id : {}", mem_id);
		
		logger.debug("body : {}", body);
		
		MemberVo memberVo = memberService.getMemberInfo(mem_id);
		logger.debug("dbmemberVO : {}", dbMemberVo);
		logger.debug("memberVo : {}", memberVo);
		logger.debug("memberVo.getMem_chk() : {}", memberVo.getMem_chk());
		logger.debug("dbMemberVo.getMem_chk() : {}", dbMemberVo.getMem_chk());
		
		if ( memberVo != null && dbMemberVo.getMem_pass().equals(memberVo.getMem_pass()) && memberVo.getMem_chk().equals("Y")) {
			session.setAttribute("S_MEMBER", memberVo);
			return "member/mypage";
		}else {
			
			return "login/memberLogin";
		}
	}
	
	
}
