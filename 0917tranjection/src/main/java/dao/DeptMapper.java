package dao;

import org.apache.ibatis.annotations.Insert;

import vo.Dept;

public interface DeptMapper {
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	
	public int insertdept(Dept dept);
}
