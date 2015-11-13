package com.als.lcs;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import com.als.frm.comm.util.FileUtil;

public class PublicKeyReader {    
    public static PublicKey get(String filename) throws Exception {
        
    	ByteArrayOutputStream out = FileUtil.readResourceFile(filename);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(out.toByteArray());
        KeyFactory kf = KeyFactory.getInstance("RSA"); 
        return kf.generatePublic(spec);
    }


}