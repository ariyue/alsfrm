package com.als.frm.verify;

import com.als.frm.comm.dto.AppData;
import com.als.frm.ex.AppException;


/**
 * 权限验证
 * @author Vincent
 *
 */
public class PermissionVerifier implements IUserVerifier {

	@Override
	public void verify(AppData appData) {

		System.out.println("permission Verifying ... ...");
		//throw new AppException("err.sys.10009", new Object[]{});
		
	}
}
