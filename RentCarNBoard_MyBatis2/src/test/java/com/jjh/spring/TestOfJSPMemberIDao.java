package com.jjh.spring;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjh.spring.dao.JSPMemberIDao;
import com.jjh.spring.dto.JSPMember;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TestOfJSPMemberIDao {

	@Inject
	private SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void 모든자료가져오기() {
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		ArrayList<JSPMember> list = dao.selectAll();

		for (JSPMember x : list) {
			System.out.println(x);
		}
	}

	public void testInsert() {
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		dao.insert("pcg", "1234", "pcg@naver.com", "010-1111-2222", "25", "학생", "독서");
	}

	public void testSelect() {
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);

		dao.select("pcg");
	}

	public void testUpdate() {
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);
		
		dao.update("pcg1234@naver.com", "010-1111-2222", "학생", "독서", "pcg");
	}

	@Test
	public void testDelete() {
		JSPMemberIDao dao = sqlSession.getMapper(JSPMemberIDao.class);
		
		dao.delete("pcg");
	}
	
	
}
