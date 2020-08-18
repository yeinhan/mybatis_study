package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig {
	private String namespace = "com.myboard.";
	
	
	public List<MyBoardDto> selectall() {
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		SqlSession session = null;
		session = getSqlSessionFactory().openSession();
		res = session.selectList(namespace+"selectAll");
		session.close();
		return res;
	}
	
	public MyBoardDto selectone(int myno) {
		SqlSession session = null;
		MyBoardDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"selectOne", myno);
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;

	
	}
	
	public int insert(MyBoardDto dto) {
		SqlSession session = null;
		int res =0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"myinsert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

		return res;
	}
	
	public int delete(int myno) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace+"delete",myno);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	
	public int update(MyBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace+"update", dto);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
