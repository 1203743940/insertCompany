package com.example.demo.mapper.sqlserver29;

import com.example.demo.model.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComMapper {
    //确认公司是否备案
    List<Company> findCompany(String companyName);
}
