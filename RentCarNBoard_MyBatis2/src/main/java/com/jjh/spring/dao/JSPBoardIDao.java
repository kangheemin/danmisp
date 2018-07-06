package com.jjh.spring.dao;

import java.util.ArrayList;

import com.jjh.spring.dto.JSPBoard;

public interface JSPBoardIDao {

	public void insert(String writer, String email, String subject, String password, String content);
	
	public ArrayList<JSPBoard> selectAll();
	
	public JSPBoard select(int num);
	
	public void upHit(int num);
	
	public void updateLevel(int ref, int re_level);
	
	public void insert2(String writer, String email, String subject, String password, int ref, int re_step, int re_level, String content);
	
	public void update(String subject, String content, int num);
	
	public void delete(int num);

}
