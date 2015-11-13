package com.als.frm.comm.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import com.als.frm.ex.AppException;

/**
 * 
 * @author Vincent 20150526
 * 
 */
public class FileUtil {

	/**
	 * 从jar包中获取文件,并读到ByteArrayOutputStream
	 * 
	 * @param path
	 *            如："/com/als/tst/cfg/customer.properties"，读取com.als.tst.cfg下的customer
	 *            .properties文件
	 * @throws IOException
	 */
	public static ByteArrayOutputStream readResourceFile(String path){
		
		ByteArrayOutputStream outputStream = null;  
		try {
			InputStream is = FileUtil.class.getResourceAsStream(path);
			
	    	 outputStream = new ByteArrayOutputStream();  
	         byte buffer[] = new byte[1024];  
	         int len = 0;  
	         while ((len = is.read(buffer)) != -1)  
	             outputStream.write(buffer, 0, len);  
			is.close();
			return outputStream;
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		// 返回读取指定资源的输入流
		// InputStream is = this.getClass().getResourceAsStream(path);
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String s = "";
		while ((s = br.readLine()) != null)
			System.out.println(s);
		return is;*/
	}

	public static String inputStream2String(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}

	/**
	 * 
	 * @param path
	 *            如："/com/als/tst/cfg/customer.properties"，读取com.als.tst.cfg下的customer
	 *            .properties文件
	 * @return map键值对
	 */
	public static Map readPropertisFile(String path) {

		try {
			InputStream is = FileUtil.class.getResourceAsStream(path);
			if(is == null){
				throw new AppException("读取不到文件：" + path);
			}
			Properties p = new Properties();
			p.load(is);
			Map m = new HashMap();
			Enumeration enumeration = p.keys();
			while (enumeration.hasMoreElements()) {
				String keyName = (String) enumeration.nextElement();
				m.put(keyName, p.getProperty(keyName));
			}
			return m;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static Document readXmlFile(String path) {

		try {
			SAXBuilder saxb = new SAXBuilder();
			InputStream is = FileUtil.class.getResourceAsStream(path);
			InputStreamReader reader = new InputStreamReader(is, "UTF-8");
			Document doc = saxb.build(reader);
			return doc;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		// ------------------test
		// properties文件读取-----------------------------------------
		// FileUtil.getResource("/com/als/tst/cfg/customer.properties");
		// FileUtil.getResource("/com/als/tst/cfg/license.xml");
		Map m = FileUtil
				.readPropertisFile("/com/als/tst/cfg/customer.properties");
		m = FileUtil.readPropertisFile("/config/als-datasource.properties");
		if (m != null) {
			// System.out.println(m.get("userName"));
			System.out.println(m.get("jdbc.url"));
		}

		// ------------------test
		// xml文件读取-----------------------------------------
		Document doc = FileUtil.readXmlFile("/com/als/tst/cfg/80002.xml");
		Element elRoot = (Element) XPath.selectSingleNode(doc.getRootElement(),
				"/efmp");// 获取根元素
		String type = elRoot.getAttribute("type").getValue().toString();// 获取属性
		System.out.println(type);
		Element elResultSet = elRoot.getChild("body").getChild("resultSet")
				.getChild("result");// (Element)XPath.selectSingleNode(docReq.getRootElement(),
									// "/efmp/body/resultSet");

		String requestId = elResultSet.getChildText("requestId");
		String cmdStatus = elResultSet.getChildText("cmdStatus");
		String resultCode = elResultSet.getChildText("resultCode");
		String resultMsg = elResultSet.getChildText("resultMsg");
		System.out.println(requestId);
		System.out.println(cmdStatus);
		System.out.println(resultCode);
		System.out.println(resultMsg);

	}
}
