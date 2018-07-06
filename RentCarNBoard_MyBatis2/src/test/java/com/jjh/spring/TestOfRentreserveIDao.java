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

import com.jjh.spring.dao.RentReserveIDao;
import com.jjh.spring.dto.RentReserve;
import com.jjh.spring.dto.ReserveView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TestOfRentreserveIDao {

	@Inject
	private SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		ArrayList<RentReserve> list = dao.selectAll();
		
		for(RentReserve x : list) {
			System.out.println(x);
		}
	}

	@Test
	public void testSelectRegNo() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		dao.selectRegno(1);
	}
	
	@Test
	public void testSelectRday() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		ArrayList<RentReserve> list = dao.selectRday("2018-06-08");
		
		for(RentReserve x : list) {
			System.out.println(x);
		}
	}
	
	@Test
	public void testSelectMemid() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		ArrayList<RentReserve> list = dao.selectMemid("jjh");
		
		for(RentReserve x : list) {
			System.out.println(x);
		}
	}
	
	public void testInsert() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		dao.insert(21, 1, 2, "2018-06-14", 1, 1, 1, 0, "jjh");
	}
	
	public void testDelete() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		dao.delete(21);
	}
	
	public void testUpdate() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		dao.update("6", "2018-06-08", "2", "1", "1", "1", "1", "1", "jjh", "1");
	}
	
	@Test
	public void testSelectAllView() {
		RentReserveIDao dao = sqlSession.getMapper(RentReserveIDao.class);
		
		ArrayList<ReserveView> list = dao.selectAllView("jjh");
		
		for(ReserveView x : list) {
			System.out.println(x);
		}
	}
}
