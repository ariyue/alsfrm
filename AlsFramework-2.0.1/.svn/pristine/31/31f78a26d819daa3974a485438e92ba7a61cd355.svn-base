package com.als.web.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//import com.ooo.oa.model.bo.TUser;


/**
 * 
 * @author Chen Zhiming
 * 
 */
public class JsonUtil {

    /**
     * 从json字符串中获取json对象
     * 
     * @param jsonStr
     * @return
     */
    public static JSONObject getJsonObject(String jsonStr) {

        return JSONObject.fromObject(jsonStr);
    }

    /**
     * 从json字符串中获取bean对象
     * 
     * @param jsonStr
     * @param beanClass
     * @return
     */
    public static Object getJsonBean(String jsonStr, Class<?> beanClass) {

        Object bean = null;
        try {
            JSONObject jsonObject = getJsonObject(jsonStr);
            bean = JSONObject.toBean(jsonObject, beanClass);
        } catch (Exception e) {
            System.out.print("由json字符串转bean异常");
        }
        return bean;

    }

    /**
     * 转为json字符串
     * 
     * @param bean
     * @return
     */
    public static String change2JsonString(Object bean) {

        return JSONObject.fromObject(bean).toString();
    }

    /**
     * 转为json字符串
     * 
     * @param list
     * @return
     */
    public static String change2JsonString(List<Object> list) {

        return JSONArray.fromObject(list).toString();
    }
    

    /**
     * 转为json字符串
     * 
     * @param list
     * @return
     */
    public static String change2JsonString(Map<Object, Object> map) {

        return JSONArray.fromObject(map).toString();
    }

   
    public static void main(String[] args) {

        /*String json = "{userName:\"chemy\",password:\"123456\"}";
        TUser user = (TUser) JsonUtil.getJsonBean(json, TUser.class);
        System.out.print(user.getUserName());

        TUser user2 = new TUser();
        user2.setPassword("123456");
        user2.setUserId("1");
        user2.setUserName("chemy");

        TUser user3 = new TUser();
        user3.setPassword("password");
        user3.setUserId("2");
        user3.setUserName("coco");

        List list = new ArrayList();
        list.add(user2);
        list.add(user3);
        String result = JsonUtil.change2JsonString(user2);
        System.out.println(result);
        
        String r = JsonUtil.change2JsonString(list);
        System.out.println(r);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", new Date());
        map.put("b", "123456");
        map.put("c", 12);
        String re = JsonUtil.change2JsonString(map);
        System.out.println(re);*/
        

    }

  /*  class User {

        private String name;

        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
    
  */
}
