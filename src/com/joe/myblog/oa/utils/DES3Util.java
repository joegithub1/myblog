package com.joe.myblog.oa.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
* Title: DES3Util
* Description: 数据加密
* @author HuangJian
* @date 2017年5月17日
*
*/
public class DES3Util {

private static final String Alogrithm="DESede";//定义加密算法
	
	private final static byte[] keyBytes = {0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10,
			 0x40, 0x38, 0x28, 0x25, 0x79, 0x51, (byte) 0xCB, (byte) 0xDD,
			 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36,
			 (byte) 0xE2}; // 24字节的密钥
	/**
	* Title: Dec3.java
	* Description: 
	* @param keybyte 加密密钥
	* @param src 加密数据缓冲区
	* @return
	* @author HuangJian
	* @date 2017年5月16日
	*/
	public static byte[] encryptMode(byte[] keybyte,byte[] src){
		SecretKey desKey =new SecretKeySpec(keybyte,Alogrithm);
		//加密
		try {
			Cipher cipher = Cipher.getInstance(Alogrithm);
			
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			
			return cipher.doFinal(src);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("cipher 1异常");
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			System.out.println("cipher 2异常");
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.out.println("init 异常");
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			System.out.println("doFinal 1异常");
			e.printStackTrace();
		} catch (BadPaddingException e) {
			System.out.println("doFinal 2异常");
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decryptMode(byte[] keybyte,byte[] src){
		
		SecretKey desKey = new SecretKeySpec(keybyte, Alogrithm);
		//解密
		try {
			Cipher cipher = Cipher.getInstance(Alogrithm);
			
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			
			return cipher.doFinal(src);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		//　添加新安全算法,如果用JCE就要把它添加进去
		Security.addProvider(new com.sun.crypto.provider.SunJCE());

		String str="This is 1001 黄";
		System.out.println("加密前:"+str);

		String enStr = encryptCode(str);
		System.out.println("加密后:"+encryptCode(str));
		
		
		System.out.println("解密后:"+deEncryptCode(enStr));
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.HOUR_OF_DAY, 2);
		
		System.out.println(sdf.format(c.getTime()));
	}
	
	
	
	/**
	 * 将明文字符串加密成密文，然后以字符串的形式返回.
	 * 说明：在将字符串明文加密后，得到的是一个byte[]数组，这时候如果将byte[]数组转化为字符串，是乱码。解决方式如下：
	 * 步骤1：对于byte[]数组中的每个元素，因为范围都在-128~127之间，所以为了方便表达，统一加上128，都转化为0或者正数；
	 * 步骤2： 利用Integer.toBinaryString()函数，将每个元素转化为16进制，结果若为单个的，用g在右侧补成2位的；
	 * 步骤3：将所有的结果统一串成一个整个的字符串，作为结果返回。
	 * @param explicitPassword
	 * @return
	 */
	public static String encryptCode(String explicitString) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		
		String implicitString = "";
		byte[] encoded = encryptMode(keyBytes, explicitString.getBytes());
		
		List<String> codeArrTemp = new ArrayList<String>();
		for (int i = 0; i < encoded.length; i++) {
			codeArrTemp.add(String.valueOf(Integer.toHexString((int) encoded[i] + 128)));
		}
		List<String> codeArr = new ArrayList<String>();
		for (int i = 0; i < codeArrTemp.size(); i++) {
			if (codeArrTemp.get(i).length() == 1) {
				String temp = codeArrTemp.get(i) + "g";
				codeArr.add(temp);
			} else {
				codeArr.add(codeArrTemp.get(i));
			}
		}
		
		for (int i = 0; i < codeArr.size(); i++) {
			implicitString += codeArr.get(i);
		}
		
		return implicitString;
	}
	
	
	
	/**
	 * 对密文解密，返回明文
	 * @param implicitString
	 * @return
	 */
	public static String deEncryptCode(String implicitString) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		
		String explicitString = null;
		byte[] encoded = null;
		//根据implicitString得到encoded
		List<String> codeArrTemp = new ArrayList<String>();
		for (int i = 0; i < implicitString.length(); i += 2) {
			codeArrTemp.add(implicitString.substring(i, i + 2));
		}
		List<String> codeArr = new ArrayList<String>();
		for (int i = 0; i < codeArrTemp.size(); i++) {
			if (codeArrTemp.get(i).contains("g")) {
				codeArr.add(codeArrTemp.get(i).substring(0, 1));
			} else {
				codeArr.add(codeArrTemp.get(i));
			}
		}
		encoded = new byte[codeArr.size()];
		for (int i = 0; i < codeArr.size(); i++) {
			encoded[i] = (byte) (Integer.parseInt(codeArr.get(i), 16) - 128);
		}
		
		byte[] srcBytes = decryptMode(keyBytes, encoded);
		explicitString = new String(srcBytes);
		return explicitString;
	}
}
