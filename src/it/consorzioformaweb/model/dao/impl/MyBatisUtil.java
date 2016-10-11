package it.consorzioformaweb.model.dao.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public SqlSessionFactory getSessionFactory() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		return new SqlSessionFactoryBuilder().build(reader);
	}
}
