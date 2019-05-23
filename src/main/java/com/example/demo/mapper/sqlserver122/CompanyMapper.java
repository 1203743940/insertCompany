package com.example.demo.mapper.sqlserver122;

import com.example.demo.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper {
    void insertCompany(@Param("companyName") String companyName, @Param("contactPerson")String contactPerson, @Param("phone")String phone);
    List<Company> findCompanyID(String company);
    //boolean getCompany(String company);
}
