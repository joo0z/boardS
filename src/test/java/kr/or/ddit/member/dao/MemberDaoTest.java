package kr.or.ddit.member.dao;

import static org.junit.Assert.*;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.member.model.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
               "classpath:kr/or/ddit/config/spring/datasource-context.xml", 
               "classpath:kr/or/ddit/config/spring/transaction-context.xml"})
public class MemberDaoTest {

	@Resource(name = "memberDao")
	private MemberDaoI memberDao;
	
	@Test
	public void getMemberInfoTest(){
		/*** Given ***/
		String mem_id = "yp0543";
		
		/*** When ***/
		MemberVo memberVo = memberDao.getMemberInfo(mem_id);

		/*** Then ***/
		assertEquals("박경섭",memberVo.getMem_name());
		
	}

}
