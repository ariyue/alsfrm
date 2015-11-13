package com.als.lcs;

import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

import com.als.frm.comm.util.FileUtil;
import com.als.frm.ex.AppException;
import com.als.lcs.u.L;

public class LicenseVerifier {

	public void check(){
		
		try {
			Map licenseMap = FileUtil.readPropertisFile("/license.properties");
			L l = new L();
			l.setIpAddress(licenseMap.get("ipAddress").toString());
			l.setMacAddress(licenseMap.get("macAddress").toString());
			l.setUserName(licenseMap.get("userName").toString());
			l.setUserType(licenseMap.get("userType").toString());
			l.setIssuedTime(licenseMap.get("issuedTime").toString());
			l.setNotBeforeTime(licenseMap.get("notBefore").toString());
			l.setNotAfterTime(licenseMap.get("notAfter").toString());
			
			String lcs = l.toString();
			String signature = licenseMap.get("signature").toString();
			
			RSAPrivateKey privKey = (RSAPrivateKey) PrivateKeyReader
			.get("/com/als/frm/log/d0");
			String input = l.toString();
			byte[] data = input.getBytes();
			String privk = Base64Utils.encode(privKey.getEncoded());
		    byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privk);
		    //System.out.println("加密后：\r\n" + new String(encodedData));
		    String sign = RSAUtils.sign(encodedData, privk);
		    if (signature.trim().equals(sign.trim())){
				System.out.println("license 验证通过!");
			} else {
				throw new Exception("license 验证失败!");
			}
		    
		}  catch (Exception e) {
			throw new AppException(e.getMessage());
		}
	}
	public static void main(String[] args) throws Exception{
		
		LicenseVerifier v = new LicenseVerifier();
		v.check();
	}
}
