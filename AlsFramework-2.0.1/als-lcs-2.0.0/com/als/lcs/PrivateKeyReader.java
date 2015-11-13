package com.als.lcs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import com.als.frm.comm.util.FileUtil;
public class PrivateKeyReader {    
    public static PrivateKey get(String filename)throws Exception {
      
        ByteArrayOutputStream out = FileUtil.readResourceFile(filename);
        PKCS8EncodedKeySpec spec =new PKCS8EncodedKeySpec(out.toByteArray());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
      }

    
    public static void main(String[] args) throws Exception, InvalidKeySpecException, IOException {
        PrivateKeyReader.get("d:/privateKeyFile");
    }
}