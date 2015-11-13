package com.als.abc.module.tst.design_patterns.chain;

import java.util.ArrayList;
import java.util.List;

import com.als.frm.comm.dto.AppData;

/**
 * 权限验证链
 * @author Vincent
 *
 */
public class UserVerifierChain implements IUserVerifier {

	private List<IUserVerifier> verifiers = new ArrayList<IUserVerifier>();
	
	public UserVerifierChain addVerifier(IUserVerifier verifier){
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
