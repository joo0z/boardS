package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

@Repository("boardDao")
public class BoardDao implements BoardDaoI{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVo> getAllBoard() {
		List<BoardVo> list = sqlSession.selectList("board.getAllBoard");
		return list;
	}

	@Override
	public int createBoard(String board_title) {
		int cnt = sqlSession.insert("board.createBoard", board_title);
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		int cnt = sqlSession.update("board.updateBoard", boardVo);
		return cnt;
	}

	@Override
	public BoardVo getBoard(int board_no) {
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", board_no);
		return boardVo;
	}

	

}
