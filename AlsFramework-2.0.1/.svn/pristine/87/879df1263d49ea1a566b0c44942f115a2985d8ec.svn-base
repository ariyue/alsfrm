package com.als.prj.abc.module.user.act;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.als.mod.domain.UmsUser;
import com.als.mod.domain.UmsUser2;
import com.als.prj.abc.module.user.biz.UmsUserBIZ;
  
/** 
 * 用户控制器 
 * 
 */  
@Controller  
public class UserACT {  
  

    
    @Autowired  
    private UmsUserBIZ  umsUserBIZImpl;
  
    @RequestMapping("/user/save")  
    @ResponseBody
    public Object save(@RequestBody  UmsUser2 user) {  
       
    	//umsUserBIZImpl.saveUser(user);
    	
    	umsUserBIZImpl.saveUser2(user);
       /* if (user != null) {  
            System.out.println("user name = " + user.getUserName());
        }  else {
        	user = new TUmUser();
        	user.setUserId("abcc");
        	user.setUserName("Chemy");
        	user.setPassword("pass");
        	umUserService.saveUser(user);
        	
        }*/
    	
    	//AjaxResultVO result = new AjaxResultVO();
    	//result.setCode("success");
        return "success";  
    }  
    
    
    @RequestMapping("/user/saveMap")  
    @ResponseBody
    public String saveMap(@RequestBody  Map params) {  
        UmsUser user = umsUserBIZImpl.getUserById("a1");
        user = new UmsUser();
    	user.setId("ccddaa");
    	user.setUserName("Chemy22");
    	user.setPassword("pass222");
    	umsUserBIZImpl.saveUser(user);
        if (user != null) {  
            System.out.println("user name = " + user.getUserName());
        }  else {
        	user = new UmsUser();
        	user.setId("abcc");
        	user.setUserName("Chemy");
        	user.setPassword("pass");
        	umsUserBIZImpl.saveUser(user);
        	
        }
        return "jsp/user/index";  
    }  
    
    @RequestMapping("/user/saveList")  
    @ResponseBody
    public String saveList(@RequestBody  List<UmsUser> users) {  
        for (int i =0, len = users.size(); i < len; i ++){
        	umsUserBIZImpl.saveUser(users.get(i));

        }
        /*if (user != null) {  
            System.out.println("user name = " + user.getUserName());
        }  else {
        	user = new TUmUser();
        	user.setUserId("abcc");
        	user.setUserName("Chemy");
        	user.setPassword("pass");
        	umUserService.saveUser(user);
        	
        }*/
        return "jsp/user/index";  
    }  
    
    
    @RequestMapping("/user/user-index")  
    @ResponseBody
    public String index(@RequestBody  Map params) {  
        UmsUser user = umsUserBIZImpl.getUserById("a1");
        user = new UmsUser();
    	user.setId("ccddaa");
    	user.setUserName("Chemy22");
    	user.setPassword("pass222");
    	umsUserBIZImpl.saveUser(user);
        if (user != null) {  
            System.out.println("user name = " + user.getUserName());
        }  else {
        	user = new UmsUser();
        	user.setId("abcc");
        	user.setUserName("Chemy");
        	user.setPassword("pass");
        	umsUserBIZImpl.saveUser(user);
        	
        }
        return "jsp/user/index";  
    }  
}  