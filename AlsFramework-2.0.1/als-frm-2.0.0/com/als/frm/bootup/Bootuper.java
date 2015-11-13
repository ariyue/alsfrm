package com.als.frm.bootup;

import java.util.ArrayList;
import java.util.List;

public class Bootuper implements IBootup {

	private List<IBootup> bootups = new ArrayList<IBootup>();
	
	public Bootuper addBootup(IBootup verifier){
		bootups.add(verifier);
		return this;
	}
	@Override
	public void bootup() {

		for (IBootup v: bootups){
			v.bootup();
		}
	}
}
