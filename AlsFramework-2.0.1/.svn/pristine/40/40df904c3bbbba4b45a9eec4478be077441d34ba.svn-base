package com.als.abc.module.cipher;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CipherTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String str = "Hello World";
		BASE64(str.getBytes());
		MessageDigest(str.getBytes());
		MD5MessageDigest(str.getBytes());
		AESCipher(str.getBytes());
		DESCipher(str.getBytes(),"pass");
		RSACipher(str.getBytes());
		DigitalSignature(str.getBytes());
	}

	/**
	 * Base64就是用来将非ASCII字符的数据转换成ASCII字符的一种方法
	 * 
	 * @param plainText
	 * @throws IOException
	 */
	public static void BASE64(byte[] plainText) throws IOException {

		String str = new BASE64Encoder().encodeBuffer(plainText);
		System.out.println("BASE64 encode-----" + str);
		// str转换BASE64
		byte[] bys = new BASE64Decoder().decodeBuffer(str);

		System.out.println("BASE64 decode-----" + new String(bys));

	}

	/**
	 * SHA消息摘要 不可逆(不可解密)
	 * 
	 * @param plainText
	 * @throws Exception
	 */
	public static void MessageDigest(byte[] plainText) throws Exception {

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

		//System.out.println("SHA消息摘要-----" + HexUtils.bytesToHexString(messageDigest.digest(plainText)));

	}

	/**
	 * MD5消息摘要 不可逆(不可解密)
	 * 
	 * @param plainText
	 * @throws Exception
	 */
	public static void MD5MessageDigest(byte[] plainText) throws Exception {

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		//System.out.println("MD5消息摘要-----" + HexUtils.bytesToHexString(messageDigest.digest(plainText)));

	}

	/**
	 * AES对称加密
	 * 
	 * @param plainText
	 * @throws Exception
	 */
	public static void AESCipher(byte[] plainText) throws Exception {
		// 初始化AES密钥
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		Key key = keyGen.generateKey();

		// 初始化Cipher
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

		// 加密
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(plainText);

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bys = cipher.doFinal(cipherText);
		System.out.println("AESCipher----" + new String(bys));
	}
	
	
	/**
	 * DES对称加密
	 * 
	 * @param plainText
	 * @throws Exception
	 */
	public static void DESCipher(byte[] plainText,String strKey) throws Exception {
		// 初始化DES密钥
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(new SecureRandom(strKey.getBytes()));
		Key key = keyGen.generateKey();

		// 初始化Cipher
		Cipher cipher = Cipher.getInstance("DES");

		// 加密
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(plainText);

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bys = cipher.doFinal(cipherText);
		System.out.println("DESCipher----" + new String(bys));
	}

	/**
	 * RSA非对称加密
	 * 
	 * @param plainText
	 * @throws Exception
	 */
	public static void RSACipher(byte[] plainText) throws Exception {
		// 初始化RSA密钥
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair key = keyGen.generateKeyPair();

		// 初始化Cipher
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		// 加密
		cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());
		byte[] cipherText = cipher.doFinal(plainText);

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
		byte[] bys = cipher.doFinal(cipherText);
		System.out.println("RSACipher----" + new String(bys));
	}

	/**
	 * RSA数字签名
	 * 
	 * @param plainText
	 * @throws Exception
	 */
	public static void DigitalSignature(byte[] plainText) throws Exception {
		// 初始化对称密钥
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair key = keyGen.generateKeyPair();

		// 初始化Signature
		Signature sig = Signature.getInstance("SHA1WithRSA");

		// 签名
		sig.initSign(key.getPrivate());
		sig.update(plainText);
		byte[] signature = sig.sign();

		// 解签
		sig.initVerify(key.getPublic());
		sig.update(plainText);
		try {
			if (sig.verify(signature)) {
				System.out.println("Signature verified");
			} else
				System.out.println("Signature failed");
		} catch (SignatureException e) {
			System.out.println("Signature failed");
		}
	}

	public static byte[] hexString2Bytes(String src) {
		byte[] ret = new byte[8];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < 8; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}
}

