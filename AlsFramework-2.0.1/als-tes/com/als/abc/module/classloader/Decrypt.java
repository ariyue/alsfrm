package com.als.abc.module.classloader;


import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 4.解密
 * @author Vincent
 *
 */
public class Decrypt {
	
	public void decr() throws Exception{
		SecureRandom sr = new SecureRandom();
		FileInputStream fi = new FileInputStream(new File("d:/key.txt"));
		byte rawKeyData[] = new byte[fi.available()];
		fi.read(rawKeyData);
		fi.close();
		DESKeySpec dks = new DESKeySpec(rawKeyData);
		SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key, sr);
		FileInputStream fi2 = new FileInputStream(new File(
				"D:/com/als/abc/module/classloader/HelloWorld.class"));
		byte encryptedData[] = new byte[fi2.available()];
		fi2.read(encryptedData);
		fi2.close();
		byte decryptedData[] = cipher.doFinal(encryptedData);
		MyClassLoader mcl = new MyClassLoader("D:/");//此时D盘为根路径
		Class cl = mcl.loadClass(decryptedData, "com.als.abc.module.classloader.HelloWorld");//HelloWorld为java的文件名(含包名
		Method mainMethod = cl.getMethod("sayHello");
		mainMethod.invoke(null, null);
		System.out.println("解密执行完成－－－－－－－－－－－－－－－－－－－－－－－－－－!");
	}

	public static void main(String[] args) throws Exception {

		Decrypt d = new Decrypt();
		d.decr();
	}
}
