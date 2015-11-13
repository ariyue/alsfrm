package com.als.frm.comm.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)
public @interface Table {
	
	/**
	 * 返回表名
	 * @return 表名,如:t_ums_user
	 */
    public String tableName(); 
    
    /**
     * 返回主键名
     * @return 主键名,如:user_id
     */
    public String keyColumnName();
}
