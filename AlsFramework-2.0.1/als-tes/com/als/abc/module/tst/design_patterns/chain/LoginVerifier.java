package com.als.abc.module.tst.design_patterns.chain;

import com.als.frm.comm.dto.AppData;


/**
 * 是否登陆验证
 * @author Vincent
 *
 */
public class LoginVerifier implements IUserVerifier {

	@Override
	public void verify(AppData appData) {

		System.out.println("login Verifying ... ...");
	}

}
