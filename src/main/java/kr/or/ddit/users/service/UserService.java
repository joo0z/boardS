package kr.or.ddit.users.service;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.users.dao.UserDaoI;
import kr.or.ddit.users.model.UserVo;

@Transactional
@Service("userService")
public class UserService implements UserServiceI {

	@Resource(name = "userDao")
	private UserDaoI userDao;

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public UserVo getUser(String user_id) {
		return userDao.getUser(user_id);
	}

}
