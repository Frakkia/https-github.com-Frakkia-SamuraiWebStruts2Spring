package it.consorzioformaweb.model.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

public abstract class AbstractMyBatisDAO {

	protected SqlSessionFactory sessionFactory;
	
	public AbstractMyBatisDAO(SqlSessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
}
