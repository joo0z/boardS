package kr.or.ddit.member.dao;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.model.MemberVo;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVo getMemberInfo(String mem_id) {
		MemberVo memberVo = sqlSession.selectOne("member.getMemberInfo", mem_id);
		return memberVo;
	}

	@Override
	public int updatePass(MemberVo memberVo) {
		int updateCnt = sqlSession.update("member.updatePass", memberVo);
		return updateCnt;
	}

	@Override
	public int dropMember(MemberVo memberVo) {
		int dropCnt = sqlSession.update("member.dropMember", memberVo);
		return dropCnt;
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		return sqlSession.insert("member.insertMember", memberVo);
	}
}
