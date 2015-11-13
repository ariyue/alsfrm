package com.als.frm.verify;

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.util.FileUtil;
import com.als.frm.comm.util.XmlUtil;

/**
 * 测试
 * @author Vincent
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static void main(String[] args) throws Exception {

		Document doc = FileUtil.readXmlFile("/config/als-app.xml");
		Element userVerifierE = XmlUtil.getChild(doc.getRootElement(), "user-verifier");
		List<Element> list = userVerifierE.getChildren();
		UserMainVerifier c = new UserMainVerifier();
		for (Element e: list){
			//System.out.println(e.getValue()); 
			Class clazz=Class.forName(e.getValue());
			c.addVerifier( (IUserVerifier)clazz.newInstance());
		
		}
		c.verify(new AppData());
	}
}
