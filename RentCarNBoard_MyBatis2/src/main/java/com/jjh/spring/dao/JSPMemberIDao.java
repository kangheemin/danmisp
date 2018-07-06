package com.jjh.spring.dao;

import java.util.ArrayList;

import com.jjh.spring.dto.JSPMember;

public interface JSPMemberIDao {

	public void insert(String id, String pass, String email, String tel, String age, String job, String hobby);

	public void delete(String id);

	public void update(String email, String tel, String job, String hobby, String id);

	public JSPMember select(String id);

	public ArrayList<JSPMember> selectAll();

	public int login(String id, String pass);
}
