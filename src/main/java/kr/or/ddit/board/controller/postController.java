package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.service.FileServiceI;
import kr.or.ddit.board.service.PostServiceI;
import kr.or.ddit.fileupload.FileUploadUtil;
import kr.or.ddit.users.model.UserVo;

@RequestMapping("/post")
@Controller
public class postController {
	private static final Logger logger = LoggerFactory.getLogger(postController.class);

	@Resource(name = "postService")
	private PostServiceI postService;
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;

	@Resource(name = "fileService")
	private FileServiceI fileService;
	
	@RequestMapping("/postList")
	public String list(Model model, int board_no,
					   @RequestParam(name="page", required = false, defaultValue = "1") int page,
					   @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize) {
		
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		logger.debug("page, pageSize : {}, pageSize : {}", page, pageSize);
		// page
		model.addAttribute("page", page);
		// pageSize
		model.addAttribute("pageSize", pageSize);
		// board_no
		model.addAttribute("board_no", board_no);

		PageVo pageVo = new PageVo();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		pageVo.setBoard_no(board_no);
		
		Map<String, Object> map = postService.selectPostPageList(pageVo);
		model.addAttribute("postList", map.get("postList"));
		model.addAttribute("pages", map.get("pages"));

		return "post/post";
	}
	
	@RequestMapping("/postContent")
	public String postContent(Model model, int post_no) {
		
		PostVo postVo = postService.getPost(post_no);
		model.addAttribute("postVo", postVo);
		logger.debug("postVo : {}", postVo);
		
//		List<FileVo> fileList = fileService.getAllFile(post_no);
//		logger.debug("fileList : {}", fileList);
//		request.setAttribute("fileList", fileList);
		
//		List<ReplyVo> replyList = replyService.getAllReply(post_no);
//		logger.debug("replyList : {}", replyList);
//		request.setAttribute("replyList", replyList);
		
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		
		return "post/postContent";
	}
	
	@RequestMapping("/createPostView")
	public String createPostView(Model model) {
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		return "post/createPost";
	}
	
	@RequestMapping(path = "/createPost", method = RequestMethod.POST)
	public String createPost(Model model, PostVo postVo,MultipartHttpServletRequest mr, HttpSession session) {
		List<BoardVo> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		
//		PostVo postVo = new PostVo();
//		postVo.setBoard_no(board_no);
//		postVo.setPost_content(post_content);
//		postVo.setPost_title(post_title);
		
		List<MultipartFile> list = mr.getFiles("realfilename");
		logger.debug("개수 : {}", list.size());
		logger.debug("제목 : {}, 게시판 : {}", postVo.getPost_title(), postVo.getBoard_no());

		logger.debug("파일 정보 : {}",list.get(0).getContentType());
	    logger.debug("파일 정보 : {}",list.get(0).getOriginalFilename());

	    UserVo userVO = (UserVo)session.getAttribute("S_MEMBER");
	    String user_id = userVO.getUser_id();
	    postVo.setUser_id(user_id);

		logger.debug("postVo : {}", postVo);

		int cnt = postService.createPost(postVo);
		logger.debug("createCnt : {}", cnt);

		String filename = "";
		String filePath = "";
		String extension = "";

		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOriginalFilename() != null && !(list.get(i).getOriginalFilename().equals(""))) {
				try {
					filename = UUID.randomUUID().toString();
					extension = FileUploadUtil.getExtension(list.get(i).getOriginalFilename());
					logger.debug("확장자 : {}", extension);
					filePath = "D:\\board\\" + filename + "." + extension;
					File uploadFile = new File(filePath);
					list.get(i).transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}

				FileVo fileVo = new FileVo();
				fileVo.setPost_no(postVo.getPost_no());
				fileVo.setFile_name(list.get(i).getOriginalFilename());
				fileVo.setFile_realnm(filePath);
				
				int insertCnt = fileService.createFile(fileVo);
				logger.debug("파일 업로드 : {}", insertCnt);
			}
		}

		if (cnt == 1) {
			return "redirect:/board/boardList?board_no="+postVo.getBoard_no();
		}else {
			return "post/createPost";
		}
		
	}
	
	@RequestMapping(path = "/postDelete", method = RequestMethod.POST)
	public String postDelete(int post_no, int board_no) {
		
		logger.debug("board_no : {}", board_no);
		logger.debug("post_no : {}", post_no);
		
		int cnt = postService.deletePost(post_no);
		logger.debug("cnt : {}", cnt);
		
		return "redirect:/post/postList?board_no="+board_no;
	}
	
	
}
