package org.apache.ibatis.mytest;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MyTestMapper {
	
	@Select("SELECT * FROM LOCKTABLE WHERE LOCKNUM = #{name}")
	LockTable getSubject(final String name);

    @Select("SELECT * FROM LOCKTABLE")
    List<LockTable> getLockTables();

}
