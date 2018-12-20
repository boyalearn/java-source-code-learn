package org.apache.ibatis.mytest;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MysqlTest {

	// public static void main(String[] args) throws IOException{
	// final Reader reader =
	// Resources.getResourceAsReader("org/apache/ibatis/mytest/mybatis-config.xml");
	// SqlSessionFactory sqlSessionFactory = new
	// SqlSessionFactoryBuilder().build(reader);
	// SqlSession session=sqlSessionFactory.openSession();
	// MyTestMapper mapper=session.getMapper(MyTestMapper.class);
	// List<LockTable> list=mapper.getLockTables();
	// LockTable lock=mapper.getSubject("sss");
	// System.out.println(list);
	// System.out.println(lock);
	// }
	//

	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
		String content = "channel=100259&c1AccNbr=18328508416&strategyId=45651232&offerCombId=151109"
	           // "&upAccNbr=18328508416&partnerAttr=0&partnerType=2"+
				//"&upUserId=1246123&partnerAttr=0&partnerType=2&upUserId=1246123"+
				//"&upAccNbr=18328508416&partnerAttr=0&partnerType=2"
				;
		SecretKeySpec keySpec = new SecretKeySpec(
				parseHexStrToByte("9DF0BD2EDFAF4B3D87ECDA965E2249C7"), "AES");
		byte[] byteContent = content.getBytes("utf-8");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		String result=parseByte2HexStr(cipher.doFinal(byteContent));
		System.out.println(result);

	}

	public static byte[] parseHexStrToByte(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static String parseByte2HexStr(byte[] src) {
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

	public String printHexString(byte[] b) {
		String a = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}

			a = a + hex;
		}

		return a;
	}

}
