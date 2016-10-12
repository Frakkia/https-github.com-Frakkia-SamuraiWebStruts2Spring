package it.consorzioformaweb.model.dao.impl;


import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import it.consorzioformaweb.model.dao.AtletaDAO;
import it.consorzioformaweb.model.dto.Atleta;
import it.consorzioformaweb.model.dto.ParameterObject;

public class AtletaMyBatisDAO extends AbstractMyBatisDAO implements AtletaDAO{

	private SqlSession session;
	
	public AtletaMyBatisDAO(SqlSessionFactory sessionFactory) throws IOException{
		super(sessionFactory);
	}
	public List<Atleta> search(){
		session = sessionFactory.openSession();
		List<Atleta> result = session.selectList("AtletaMapping.getAll");
		session.close();
		return result;
	}
	
	public List<Atleta> searchByIdSocieta(Integer id){
		session = sessionFactory.openSession();
		List<Atleta> result = session.selectList("AtletaMapping.getByIdSocieta",id);
		session.close();
		return result;
	}
	
	public List<Atleta> searchByAll(ParameterObject po){
		session = sessionFactory.openSession();
		
		List<Atleta> result = session.selectList("AtletaMapping.getByAll",po);
		session.close();
		return result;
	}
	
	public Integer create(Atleta a){
		session = sessionFactory.openSession();
		session.insert("AtletaMapping.insertPersona",a);
		session.insert("AtletaMapping.insertAtleta",a);
		session.commit();
		session.close();
		return a.getId();
	}
	
	public Atleta read(int id){
		session = sessionFactory.openSession();
		Atleta  result = session.selectOne("AtletaMapping.getById", id);
		session.close();
		return result;
	}
	
	public void update(Atleta a){
		session = sessionFactory.openSession();
		session.update("AtletaMapping.updatePersona", a);
		session.update("AtletaMapping.updateAtleta", a);
		session.commit();
		session.close();
	}
	
	public void delete(Atleta a){
		
		session = sessionFactory.openSession();
		session.delete("AtletaMapping.deleteAtleta",a);
		session.delete("AtletaMapping.deletePersona", a);		
		session.commit();
		session.close();
	}
}
