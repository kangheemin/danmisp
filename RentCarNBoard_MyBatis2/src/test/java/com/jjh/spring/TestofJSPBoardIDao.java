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

import com.jjh.spring.dao.JSPBoardIDao;
import com.jjh.spring.dto.JSPBoard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TestofJSPBoardIDao {

	@Inject
	private SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		ArrayList<JSPBoard> list = dao.selectAll();

		for (JSPBoard x : list) {
			System.out.println(x);
		}
	}
	
	public void testInsert() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		dao.insert("정진혁", "jungjh114@naver.com", "게시판테스트", "1234", "테스트 결과는 ?");
	}

	public void testSelect() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		JSPBoard dto = dao.select(2);

		System.out.println(dto);
	}

	
	public void testUpHit() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);

		dao.upHit(2);
		JSPBoard dto = dao.select(2);

		System.out.println(dto);
	}
	
	public void testUpdateLevel() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);
		
		dao.updateLevel(1, 1);
		
		dao.insert2("박천기", "123@naver.com", "댓글테스트", "1234", 1, 1, 1, "되나?");
	}
	
	public void testUpdate() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);
		
		dao.update("업데이트테스트", "업데이트성공", 1);
	}
	
	@Test
	public void testDelete() {
		JSPBoardIDao dao = sqlSession.getMapper(JSPBoardIDao.class);
		
		dao.delete(4);
	}
}
