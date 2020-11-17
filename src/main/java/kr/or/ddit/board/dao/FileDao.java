package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.FileVo;

@Repository("fileDao")
public class FileDao implements FileDaoI{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public int createFile(FileVo fileVo) {
		int	cnt = sqlSession.insert("post.createFile", fileVo);
		return cnt;
	}

	@Override
	public List<FileVo> getAllFile(int post_no) {
		List<FileVo> list = sqlSession.selectList("post.getAllFile", post_no);
		return list;
	}

	@Override
	public FileVo getFile(int file_no) {
		FileVo fileVo = sqlSession.selectOne("post.getFile", file_no);
		return fileVo;
	}

	@Override
	public int deleteFile(int file_no) {
		int	cnt = sqlSession.delete("post.deleteFile", file_no);
		return cnt;
	}

}
