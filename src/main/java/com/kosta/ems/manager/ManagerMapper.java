package com.kosta.ems.manager;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManagerMapper {
	Map<String, String> login(@Param("employeeNumber") String employeeNumber, @Param("password") String password);
	
}