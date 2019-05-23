package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private String userID;
    private String attributeGUID;
    private String attributeID;
    private String account ;
    //联系人联系方式
    private String remark;
}
