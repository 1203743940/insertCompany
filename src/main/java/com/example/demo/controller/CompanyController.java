package com.example.demo.controller;

import com.example.demo.mapper.sqlserver122.AttributeIDMapper;
import com.example.demo.mapper.sqlserver122.CompanyMapper;
import com.example.demo.mapper.sqlserver122.UserMapper;
import com.example.demo.mapper.sqlserver29.ComMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {
    @Autowired
    CompanyMapper companyMapper  ;
    @Autowired
    AttributeIDMapper attributeIDMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ComMapper comMapper;



    @RequestMapping(value = "/insertCom")
    public ModelAndView getDriverInfo(@RequestParam(value = "companyName") String companyName,
                                      @RequestParam(value = "phone",required = false) String phone,
                                      @RequestParam(value = "contactPerson",required = false) String contactPerson,
                                      @RequestParam(value = "account") String account,ModelMap modelMap){

        //autogateDB 表companys 查询有没有拖车平台备案
        if (comMapper.findCompany(companyName).size()==0){
            String tips = companyName+"目前还没有备案！！！";
            modelMap.addAttribute("tips",tips);
            return new ModelAndView("search",modelMap);
        }
        //确认TK账号无绑定其他公司
        if (userMapper.findUser(account).get(0).getAttributeID()!= null){
            System.out.println(userMapper.findUser(account).get(0).getAttributeID());
            System.out.println(userMapper.findUser(account).get(0).getAttributeGUID());

            String tips = account+"的账号属于其他公司，请核查后";
            modelMap.addAttribute("tips",tips);
            return new ModelAndView("search",modelMap);
        }

        /*查看是不是有这家公司，如果没有插入值，获取[CompanyID]。*/

        if (companyMapper.findCompanyID(companyName).size()==0){
            companyMapper.insertCompany(companyName,contactPerson,phone);
        }
        //
        String companyID = companyMapper.findCompanyID(companyName).get(0).getCompanyID();
        System.out.println(companyID+companyName);
        //获取 [AttributeGUID] 值
        String attributeGUID = attributeIDMapper.findAttributeGUID();
        //插入值[AttributeID] ,[AttributeGUID]，[CompanyID]
        attributeIDMapper.insert(companyID,attributeGUID);

        String attributeID = attributeIDMapper.findAttributeID(attributeGUID).get(0).getAttributeID();
        String remark = contactPerson + phone;

        //更新 [AttributeID] 和 [AttributeGUID]

        userMapper.updateUser(attributeID,remark,attributeGUID,account);

        String tips = "账户:"+account+" 公司名："+companyName+"已插入成功！！！";
        modelMap.addAttribute("tips",tips);
        return new ModelAndView("search",modelMap);

    }
    @RequestMapping
    public  ModelAndView index(){
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/getLastAccount" )
    public  ModelAndView getLastAccount(ModelMap modelMap){
        String lastAccount = userMapper.findUserLast().get(0).getAccount();
        String tips = "最后一个账号为"+lastAccount;
        modelMap.addAttribute("tips",tips);
        return new ModelAndView("search",modelMap);


    }

}
