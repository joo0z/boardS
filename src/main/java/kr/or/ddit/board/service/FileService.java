package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.FileDaoI;
import kr.or.ddit.board.model.FileVo;

@Transactional													
@Service("fileService")
public class FileService implements FileServiceI{

	@Resource(name = "fileDao")
	private FileDaoI fileDao;

	@Override
	public int createFile(FileVo fileVo) {
		return fileDao.createFile(fileVo);
	}

	@Override
	public List<FileVo> getAllFile(int post_no) {
		return fileDao.getAllFile(post_no);
	}

	@Override
	public FileVo getFile(int file_no) {
		return fileDao.getFile(file_no);
	}

	@Override
	public int deleteFile(int file_no) {
		return fileDao.deleteFile(file_no);
	}
	

}
