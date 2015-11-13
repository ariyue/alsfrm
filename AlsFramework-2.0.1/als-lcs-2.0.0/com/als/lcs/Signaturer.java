package com.als.lcs;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import com.als.frm.comm.util.Base64Util;

/**
 * 使用私钥进行签名
 * @author Vincent
 *
 */
public class Signaturer {
	public static byte[] sign(byte[] priKeyText, String plainText) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Util
					.decode(new String(priKeyText)));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey prikey = keyf.generatePrivate(priPKCS8);
			// 用私钥对信息生成数字签名
			Signature signet = java.security.Signature
					.getInstance("MD5withRSA");
			signet.initSign(prikey);
			signet.update(plainText.getBytes());
			byte[] signed = Base64Util.encode(signet.sign()).getBytes();
			return signed;
		} catch (java.lang.Exception e) {
			System.out.println("签名失败");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		
		Signaturer s = new Signaturer();
		s.sign("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALsAGC2SnkJP+f8G3F7Ty/B3EMuPCr9NECqPXl8ZHFtuV9BIvg0eQWhey+M/FecpNWUQ+LCgWjpNpPTvAE4uFrEngFvFYCP39Se3ogqA92S18nzsu7E8Wvw7yV0EOfMFkYugSwBAlyRzJHPf5wQtc2FMDgAT8Vd2qw58vryyfNeBAgMBAAECgYEArKmJqYqXVeNCkZdkIqqsw3sspseMxNYC90kpeeVVqZZYvphr4vDss9HTsB+vuaDzDD5/YZatuOe4R+/l+EnV6GjN/DE5RdSb/qYnVUk8d8F0ICxVFtHq9qcOZew1y4D6rImpsf9rl1/pcCO7B1a4505oWwtUzm9Gp3tKC1Qhn4ECQQDfaJ7/CraEBY/mIU66u7no+fTGO198jZQSyH+m2DYrOTXPX+wNEyJgU5lYT435+D1OQCQL4Oo/lISjAS4/QzD7AkEA1kfGhnrUarj0RcRxHGTRZGieNxAT2g7kxGVlTqTI8MqsK0G9P/sLXa0uaIr1yZ1Do5N4t0/PWNflw5mEk0FIswJBANGJsvbK+XzCKsFRpCIISMp3BlmW/mw37hXf77pxN/06X3ntIdzxgWCPiFgH5cX6SqXGCwkJHywbBHxOcy3qu1kCQCU6TxlqGaF5BKdiW6xtL5vcOTCj0G8gC0q7uwAQzQBYldTmFPUarnzV66wqCE3AztGKe3yNlx5+U+LJtyjGPNUCQEKMtc8K/RbEqMB5glx/lE9NX67d6XW1EKf1DAWH1qJ3IpZ0vOtRpqqNDKbkNXt+RCkyotr0yTIgf3FmS2BhJV4=".getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7ABgtkp5CT/n/Btxe08vwdxDLjwq/TRAqj15fGRxbblfQSL4NHkFoXsvjPxXnKTVlEPiwoFo6TaT07wBOLhaxJ4BbxWAj9/Unt6IKgPdktfJ87LuxPFr8O8ldBDnzBZGLoEsAQJckcyRz3+cELXNhTA4AE/FXdqsOfL68snzXgQIDArrQAB");
		
	}
}