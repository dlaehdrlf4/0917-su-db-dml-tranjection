package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.mybatis.domain.PersonVO;

//자동으로 bean을 생성해주는 어노테이션
@Repository
public class PersonDao {
	//동일한 자료형의 bean이 있으면 자동으로 주입받는 어노테이션
//@Autowired
private SqlSession sqlSession;

	//person 테이블의 전체 데이터를 가져오는 메소드
	public List<PersonVO> list(){
		return sqlSession.selectList("person.list");
	}
	
	//person 테이블에서 id를 가지고 하나의 데이터를 찾아오는 메소드
	public PersonVO listid(String id) {
		//하나를 찾아오는 메소드 호출
		//없으면 null을 리턴
		//2개 이상이면 예외를 발생시킵니다.
		return sqlSession.selectOne("person.select", id);
	}
	
	public int insertuser(PersonVO vo) {
		return sqlSession.insert("person.insert", vo);
	}
	
	//Person 테이블에 데이터를 삽입하는 메소드
	public int insertprocedure(PersonVO vo) {
		return sqlSession.insert("person.insertproc", vo);
	}
	
	

}
