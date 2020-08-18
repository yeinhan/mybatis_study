package com.multi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.multi.dto.MDBoardDto;

public class MDBoardDao extends SqlMapConfig {
	private String namespace="com.my.multi.";
	
	//게시판 목록
	public List<MDBoardDto> selectAll(){
		List<MDBoardDto> res = new ArrayList<MDBoardDto>();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectList(namespace+"selectAll");
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	//게시글 등록
	public int insert(MDBoardDto dto) {
		SqlSession session = null;
		int res=0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert",dto);
			
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
	
	//글 선택
	public MDBoardDto selectOne(int seq) {
		MDBoardDto res = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"selectOne", seq);
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	//글 수정
	public int update(MDBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
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
	
	//글 삭제
	public int delete(int seq) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"delete",seq);
			
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
	
	//다중 삭제
	public int multiDelete(String[] seq) {
		int count =0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seq",seq);
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			count = session.delete(namespace+"muldel", map);
			
			if(count == seq.length) {
				session.commit();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
