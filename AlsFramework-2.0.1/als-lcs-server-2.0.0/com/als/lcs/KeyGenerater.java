package com.als.lcs;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import com.als.frm.comm.util.Base64Util;


/**
 * 生成公钥私钥对
 * @author Vincent
 *
 */
public class KeyGenerater {
	private String priKey;
	private String pubKey;

	public void generater() {
		try {
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			SecureRandom secrand = new SecureRandom();
			secrand.setSeed("AlsFramwork-2.0.0-dev".getBytes()); // 初始化随机产生器
			keygen.initialize(1024, secrand);
			KeyPair keys = keygen.genKeyPair();
			PublicKey pubkey = keys.getPublic();
			PrivateKey prikey = keys.getPrivate();
			pubKey = Base64Util.encode(pubkey.getEncoded());
			priKey = Base64Util.encode(prikey.getEncoded());
			//pubKey = Base64.encodeToByte(pubkey.getEncoded());
			//priKey = Base64.encodeToByte(prikey.getEncoded());
			System.out.println("pubKey = " + new String(pubKey));
			System.out.println("priKey = " + new String(priKey));
			
			//FileInputStream f=new FileInputStream("key1.dat");
			//ObjectInputStream b=new ObjectInputStream(f);
			//Key k=(Key)b.readObject( );
			
			
			
			//KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); 
	        //SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes());
	        //keyPairGenerator.initialize(1024, secureRandom);
	        //KeyPair keyPair = keyPairGenerator.genKeyPair();
	        String publicKeyFilename = "D:/d1";
	        byte[] publicKeyBytes = keys.getPublic().getEncoded();
	        FileOutputStream fos = new FileOutputStream(publicKeyFilename); 
	        fos.write(publicKeyBytes); 
	        fos.close();
	        String privateKeyFilename = "D:/d0"; 
	        byte[] privateKeyBytes = keys.getPrivate().getEncoded();
	        fos = new FileOutputStream(privateKeyFilename); 
	        fos.write(privateKeyBytes); 
	        fos.close();
			
		} catch (java.lang.Exception e) {
			System.out.println("生成密钥对失败");
			e.printStackTrace();
		}
	}

	public String getPriKey() {
		return priKey;
	}

	public String getPubKey() {
		return pubKey;
	}
	
	public static void main(String[] args) {
		
		KeyGenerater k = new KeyGenerater();
		k.generater();
	}
}