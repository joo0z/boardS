package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.PostDaoI;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

@Transactional													
@Service("postService")
public class PostService implements PostServiceI{

	@Resource(name = "postDao")
	private PostDaoI postDao;
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<PostVo> getAllPost(int board_no) {
		return postDao.getAllPost(board_no);
	}
	
	@Override
	public Map<String, Object> selectPostPageList(PageVo pageVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postList", postDao.selectPostPageList(sqlSession, pageVo));
		
		int cnt = postDao.selectPostTotalCnt(sqlSession,pageVo.getBoard_no());
		int pages = (int)Math.ceil((double)cnt/pageVo.getPageSize());
		map.put("pages", pages);
		
		return map;
	}
	
	@Override
	public int selectPostTotalCnt(int board_no) {
		return postDao.selectPostTotalCnt(sqlSession, board_no);
	}
	
	@Override
	public PostVo getPost(int post_no) {
		return postDao.getPost(post_no);
	}
	
	@Override
	public int createPost(PostVo postVo) {
		return postDao.createPost(postVo);
	}

	@Override
	public int deletePost(int post_no) {
		return postDao.deletePost(post_no);
	}

	@Override
	public int updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}

	@Override
	public int createAnswer(PostVo postVo) {
		return postDao.createAnswer(postVo);
	}

}
