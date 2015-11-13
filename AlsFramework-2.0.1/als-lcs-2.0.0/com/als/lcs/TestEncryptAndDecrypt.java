package com.als.lcs;

import java.net.URL;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.als.frm.comm.util.Base64Util;
import com.als.frm.comm.util.encryp.EncrypRSA;

public class TestEncryptAndDecrypt {    
    public static void main(String[] args) throws Exception {
    	
    	 URL url = Test.class.getClass().getResource("/com/als/frm/log/");
 		 String p = url.getPath().substring(1);
 		 System.out.println(p); 
         
         RSAPublicKey pubKey = (RSAPublicKey) PublicKeyReader.get(p +"a");
         RSAPrivateKey privKey = (RSAPrivateKey) PrivateKeyReader.get(p +"o");
         
         
        //String input = "thisIsMyPassword$7788#&@()*%";
    	//TODO 读取license
        String input = "abc";//"Product.name=als;Product.version=2.0.0;License.type=dev;License.expiry=2015-05-12;Server.macaddress=00-1B-77-2C-9D-8F";
        EncrypRSA rsa = new EncrypRSA();
        byte[] cipherText = rsa.encrypt(pubKey, input.getBytes());
       
        
        
        //加密后的东西
        System.out.println("cipher: " + new String(cipherText)); 
        
        //为了方便传播，加密后采用Base64位字符串进行传播
        //byte[] cipherText64 = Base64.encodeToByte(cipherText);
        String cipherText64 =   Base64Util.encode(cipherText);//Base64.encode(cipherText);
        System.out.println("cipher64: " + cipherText64);    
        
          
       
        //开始解密
        //先解开base64
        //byte[] plainText64 = Base64.decode(cipherText64);
        byte[] plainText64 = Base64Util.decode(cipherText64);
        System.out.println("plain64 : " + new String(plainText64));
        
        //再进行解密
        byte[] plainText = rsa.decrypt(privKey, plainText64);
        
        
        System.out.println("plain : " + new String(plainText));
    }

}
