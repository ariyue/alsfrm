package com.als.web.action;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.util.XmlUtil;
import com.als.frm.verify.IUserVerifier;
import com.als.frm.verify.UserMainVerifier;

/**
 * 权限验证
 * @author Vincent
 *
 */
public class SecurityChecker {

	private static SecurityChecker instance = new SecurityChecker();
	
	private UserMainVerifier c;
	
	private SecurityChecker() {
		try {
			Document doc = FrmConstant.appCfgDocument;
			Element userVerifierE = XmlUtil.getChild(doc.getRootElement(), "user-verifier");
			List<Element> list = userVerifierE.getChildren();
			c = new UserMainVerifier();
			for (Element e: list){
				//System.out.println(e.getValue()); 
				Class clazz=Class.forName(e.getValue());
				c.addVerifier( (IUserVerifier)clazz.newInstance());
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SecurityChecker getInstance(){
		if (instance == null){
			instance = new SecurityChecker();
		}
		return instance;
	}
	
	public void check(AppData appData) throws Exception {

		c.verify(appData);
		
	}
}
