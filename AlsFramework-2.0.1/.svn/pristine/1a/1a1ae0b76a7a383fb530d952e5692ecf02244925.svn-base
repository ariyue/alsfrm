package com.als.lcs;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import com.als.frm.comm.util.FileUtil;
import com.als.lcs.u.L;

public class LicenseGenerater {
	public static void main(String[] args) throws Exception {

		RSAPublicKey pubKey = (RSAPublicKey) PublicKeyReader.get("/com/als/frm/log/d1");
		RSAPrivateKey privKey = (RSAPrivateKey) PrivateKeyReader.get("/com/als/frm/log/d0");

		// String input = "thisIsMyPassword$7788#&@()*%";
		//读取license先成的properties
		Map createLicenseMap = FileUtil.readPropertisFile("/com/als/lcs/createLicense4dev.properties");
		L l = new L();
		l.setIpAddress(createLicenseMap.get("ipAddress").toString());
		l.setMacAddress(createLicenseMap.get("macAddress").toString());
		l.setUserName(createLicenseMap.get("userName").toString());
		l.setUserType(createLicenseMap.get("userType").toString());
		l.setIssuedTime(createLicenseMap.get("issuedTime").toString());
		l.setNotBeforeTime(createLicenseMap.get("notBefore").toString());
		l.setNotAfterTime(createLicenseMap.get("notAfter").toString());
		//String input = "Product.name=als;Product.version=2.0.0;License.type=dev;License.expiry=2015-05-12;Server.macaddress=00-1B-77-2C-9D-8F";
		
		String input = l.toString();
		byte[] data = input.getBytes();
		String privk = Base64Utils.encode(privKey.getEncoded());
	    byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privk);
	    System.out.println("加密后：\r\n" + new String(encodedData));
		
	    
	    String pubk = Base64Utils.encode(pubKey.getEncoded());
	    byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, pubk);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privk);
        System.err.println("签名:\rsignature=" + sign);
        boolean status = RSAUtils.verify(encodedData, pubk, sign);
        System.err.println("验证结果:\r" + status);
	}

}
