package kr.or.ddit.users.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.users.model.UserVo;

@Repository("userDao")
public class UserDao implements UserDaoI{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public UserVo getUser(String user_id) {
		UserVo userVo = sqlSession.selectOne("user.getUser", user_id);
		return userVo;
	}
	

}
