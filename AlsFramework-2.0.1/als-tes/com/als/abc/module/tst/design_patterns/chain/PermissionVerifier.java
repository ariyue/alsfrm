package com.als.abc.module.tst.design_patterns.chain;

import com.als.frm.comm.dto.AppData;


/**
 * 权限验证
 * @author Vincent
 *
 */
public class PermissionVerifier implements IUserVerifier {

	@Override
	public void verify(AppData appData) {

		System.out.println("permission Verifying ... ...");
		
	}
}
