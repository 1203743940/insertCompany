package com.example.demo.mapper.sqlserver122;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //void updateAttributeID(String attributeID,String account);
    //void updateRemark(String remark,String account);
   // void updateAttributeGUID(String attributeGUID,String account);
    List<User> findUser (String account);
    void updateUser(@Param("attributeID") String attributeID, @Param("remark") String remark, @Param("attributeGUID") String attributeGUID,@Param("account") String account);
    List<User> findUserLast ();
}
