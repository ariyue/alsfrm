package com.als.frm.bootup;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.util.XmlUtil;
import com.als.frm.spr.SpringContextUtil;

@Component
public class BootupMain implements
		ApplicationListener<ContextRefreshedEvent> {

	private Bootuper c;
	
	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// root// application// context// 没有parent，他就是老大
		//防止多次执行
		if (event.getApplicationContext().getParent() == null) {
			System.out.println("als app bootup start ****************************************************** ");
			Document doc = FrmConstant.appCfgDocument;
			Element bootupE = XmlUtil.getChild(doc.getRootElement(), "app-bootup");
			List<Element> list = bootupE.getChildren();
			c = new Bootuper();
			for (Element e: list){
				//Class clazz=Class.forName(e.getValue());
				//c.addBootup( (IBootup)clazz.newInstance());
				IBootup bootup = (IBootup)  SpringContextUtil
				.getBean(e.getValue());
				c.addBootup(bootup);
			}
			c.bootup();
			System.out.println("als app bootup finish ****************************************************** ");
		}
	}
}
