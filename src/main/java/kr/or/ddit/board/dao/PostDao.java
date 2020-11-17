package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

@Repository("postDao")
public class PostDao implements PostDaoI{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<PostVo> getAllPost(int board_no) {
		List<PostVo> list = sqlSession.selectList("post.getAllPost",board_no);
		return list;
	}

	@Override
	public int selectPostTotalCnt(SqlSession sqlSession, int board_no) {
		return sqlSession.selectOne("post.selectPostTotalCnt", board_no);
	}

	@Override
	public List<PostVo> selectPostPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("post.selectPostPageList", pageVo);
	}

	@Override
	public PostVo getPost(int post_no) {
		PostVo postVo = sqlSession.selectOne("post.getPost", post_no);
		return postVo;
	}

	@Override
	public int createPost(PostVo postVo) {
		int	cnt = sqlSession.insert("post.createPost", postVo);
		return cnt;
	}

	@Override
	public int deletePost(int post_no) {
		int cnt = sqlSession.delete("post.deletePost", post_no);
		return cnt;
	}

	@Override
	public int updatePost(PostVo postVo) {
		int cnt = sqlSession.delete("post.updatePost", postVo);
		return cnt;
	}

	@Override
	public int createAnswer(PostVo postVo) {
		int	cnt = sqlSession.insert("post.createAnswer", postVo);
		return cnt;
	}
	
}
