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

import com.jjh.spring.dao.RentCarIDao;
import com.jjh.spring.dto.RentCar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TestOfRentcarIDao {

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
		RentCarIDao dao = sqlSession.getMapper(RentCarIDao.class);
		ArrayList<RentCar> list = dao.selectAll();
		for (RentCar x : list) {
			System.out.println(x);
		}
	}

	@Test
	public void testSelectNo() {
		RentCarIDao dao = sqlSession.getMapper(RentCarIDao.class);
		
		RentCar dto = dao.selectNo(1);
		
		System.out.println(dto);
	}
	
	@Test
	public void testSelectCategory() {
		RentCarIDao dao = sqlSession.getMapper(RentCarIDao.class);
		
		ArrayList<RentCar> list = dao.selectCategory(2);
		
		for(RentCar x : list) {
			System.out.println(x);
		}
	}
	
	public void testInsert() {
		RentCarIDao dao = sqlSession.getMapper(RentCarIDao.class);
		
		dao.insert("RangeRover", 3, 80000, 5, "RandRover", "RangeRover.jsp", "레인지로버");
	}

	public void testDelete() {
		RentCarIDao dao = sqlSession.getMapper(RentCarIDao.class);
		
		dao.insert("RangeRove", 3, 80000, 5, "RandRover", "RangeRover.jsp", "레인지로버");
		
		dao.delete("22");
	}

	@Test
	public void testUpdate() {
		RentCarIDao dao = sqlSession.getMapper(RentCarIDao.class);
		
		dao.update("evoque", "3", "80000", "5", "RandRover", "RangeRover.jsp", "레인지로버 이보크", "21");
	}
}
