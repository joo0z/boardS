package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.validation.BindingResult;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/member")
	public String member(@RequestParam(name="mem_id") String mem_id,
						 Model model) {
		MemberVo memberVo = memberService.getMemberInfo(mem_id);
		model.addAttribute("memberVo", memberVo);
//		return "member/member";
		return "member/mypage";
	}
	
	@RequestMapping("/memberAjax")
	public String memberAjax(String mem_id,	 Model model) {
		MemberVo memberVo = memberService.getMemberInfo(mem_id);
		model.addAttribute("memberVo", memberVo);
		// 응답 html ==> jsp로 생성
		return "jsonView";
		// model 객체를 jsonView로 만들어 준다.
	}
	
	@RequestMapping(path = "/updatePass", method = RequestMethod.POST)
	public String memberUpdate(String mem_id, String mem_pass) {
		logger.debug("mem_pass : {}, mem_id : {}", mem_pass, mem_id);
		MemberVo memberVo = memberService.getMemberInfo(mem_id);
		memberVo.setMem_pass(mem_pass);
		memberVo.setMem_id(mem_id);
		
		int cnt = memberService.updatePass(memberVo);
		logger.debug("cnt : {}", cnt);
		return "redirect:/member/member?mem_id=" + mem_id;
	}
	
	@RequestMapping(path = "/dropMember", method = RequestMethod.POST)
	public String dropMember(String mem_id) {
		logger.debug("mem_id : {}", mem_id);
		MemberVo memberVo = memberService.getMemberInfo(mem_id);
		memberVo.setMem_id(mem_id);
		int dropCnt = memberService.dropMember(memberVo);
		logger.debug("dropCnt : {}", dropCnt);
		return "redirect:/login/memberLogin";
	}
	
	@RequestMapping("/Regist")
	public String memberViewRegist() {
//		return "member/memberRegist"; // /WEB-INF/views/multi/view/
		return "member/memberRegist";
	}
	
	@RequestMapping("/regist")
	public String memberRegist(MemberVo memberVo, BindingResult br) {
		//검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
//		if(br.hasErrors()) {
//			return "tiles/member/memberRegistContent";
//		}
		logger.debug("memberVo : {}" , memberVo);
		int insertCnt = memberService.insertMember(memberVo);
		logger.debug("insertCnt : {}", insertCnt);
		
		return "redirect:/login/memberLogin";
	}
	
	
}
