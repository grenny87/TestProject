package com.main;
import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class TestCryptoAes {



	    private static final String ALGORITHM = "AES";
	    private static final String keyValue = "4D92199549E0F2EF009B4160F3582E5528A11A45017F3EF8";

	    public static void main(String args[]) throws Exception {
	        String encriptValue = encrypt("Hom nay tao di da bong");
	        decrypt(encriptValue);

	    }

	    /**
	     * @param args
	     * @throws Exception
	     */

	    public static String encrypt(String valueToEnc) throws Exception {
	    	IvParameterSpec iv = buildIvParameterSpec();
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        System.out.println(Cipher.getMaxAllowedKeyLength("4D92199549E0F2EF009B4160F3582E5528A11A45017F3EF8")); 
	        c.init(Cipher.ENCRYPT_MODE, key, iv );
	        byte[] hexByte = Hex.decodeHex("4D92199549E0F2EF009B4160F3582E5528A11A45017F3EF8".toCharArray());
	        byte[] hexByte2 = extractHexStringToByte("4D92199549E0F2EF009B4160F3582E5528A11A45017F3EF8");
	        System.out.println("valueToEnc.getBytes().length "+valueToEnc.getBytes().length);
	        byte[] encValue = c.doFinal(valueToEnc.getBytes());
	        
	        System.out.println("encValue hex string " + Hex.encodeHexString(encValue));
	        String cipherText = Base64.encodeBase64String(encValue);
	        System.out.println("encValue length " + encValue.length );
	        System.out.println("encryptedValue " + cipherText);

	        return cipherText;
	    }

		private static IvParameterSpec buildIvParameterSpec() {
			String ivStr = "35B2FF0795FB84BBD666DB8430CA214E";
	    	
	    	
	    	byte[] ivBytes = extractHexStringToByte(ivStr);
	    	
	    	
	    	
	    	IvParameterSpec iv = new IvParameterSpec(ivBytes);
			return iv;
		}

		private static byte[] extractHexStringToByte(String ivStr) {
			byte[] ivBytes = new byte[ivStr.length()/2];
	    	
	    	for(int i = 0; i < ivStr.length(); i+=2) {
	    		ivBytes[i/2] = (byte) Integer.parseInt(ivStr.substring(i, i + 2) , 16);
	    	}
			return ivBytes;
		}

	    public static String decrypt(String encryptedValue) throws Exception {
	    	IvParameterSpec iv = buildIvParameterSpec();
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        c.init(Cipher.DECRYPT_MODE, key, iv);

	        byte[] enctVal = c.doFinal(Base64.decodeBase64(encryptedValue));
	        System.out.println("enctVal length " + enctVal.length);

	        byte[] decordedValue = new Base64().decode(enctVal);
	        System.out.println("decordedValue " + new String(enctVal, "UTF-8"));
	        return decordedValue.toString();
	    }

	    private static Key generateKey() throws Exception {
//	    	MessageDigest md = MessageDigest.getInstance("SHA-256");
//	    	byte[] b = md.digest(keyValue); 
	        Key key = new SecretKeySpec(Hex.decodeHex(keyValue.toCharArray()), ALGORITHM);
//	    	Key key = new SecretKeySpec(keyValue, ALGORITHM);
	        return key;
	    }

}
