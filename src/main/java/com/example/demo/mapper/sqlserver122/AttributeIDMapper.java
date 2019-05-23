package com.example.demo.mapper.sqlserver122;

import com.example.demo.model.AttributeID;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttributeIDMapper {
    void insert(@Param("companyID")String companyID, @Param("attributeGUID")String attributeGUID);
    //感觉mapperxml写错
    String findAttributeGUID();
    List<AttributeID> findAttributeID(String attributeGUID);
}
