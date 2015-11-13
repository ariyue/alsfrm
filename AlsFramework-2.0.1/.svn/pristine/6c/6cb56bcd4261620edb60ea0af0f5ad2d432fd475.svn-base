package com.als.frm.verify;

import java.util.ArrayList;
import java.util.List;

import com.als.frm.comm.dto.AppData;

/**
 * 权限验证链
 * @author Vincent
 *
 */
public class UserMainVerifier implements IUserVerifier {

	private List<IUserVerifier> verifiers = new ArrayList<IUserVerifier>();
	
	public UserMainVerifier addVerifier(IUserVerifier verifier){
		verifiers.add(verifier);
		return this;
	}
	@Override
	public void verify(AppData appData) {

		for (IUserVerifier v: verifiers){
			v.verify(appData);
		}
	}
}
