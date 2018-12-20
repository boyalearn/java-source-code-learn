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

	 public static void main(String[] args) throws IOException{
		 final Reader reader =Resources.getResourceAsReader("org/apache/ibatis/mytest/mybatis-config.xml");
		 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		 SqlSession session=sqlSessionFactory.openSession();
		 MyTestMapper mapper=session.getMapper(MyTestMapper.class);
		 List<LockTable> list=mapper.getLockTables();
		 LockTable lock=mapper.getSubject("sss");
		 System.out.println(list);
		 System.out.println(lock);
	 }
	

}
