package it.consorzioformaweb.model.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import it.consorzioformaweb.model.dao.SquadraDAO;
import it.consorzioformaweb.model.dto.Squadra;

public class SquadraMyBatisDAO extends AbstractMyBatisDAO implements SquadraDAO{

	private SqlSession session;
	
	public SquadraMyBatisDAO(SqlSessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<Squadra> search(){
		session = sessionFactory.openSession();
		List<Squadra> result = session.selectList("SquadraMapping.getAll");
		session.close();
		return result;
	}
	
	public List<Squadra> searchByTorneo(Integer t){
		List<Squadra> result;
		session = sessionFactory.openSession();
		if (t == -1){
			result = session.selectList("SquadraMapping.getAll");
		} else{
			result = session.selectList("SquadraMapping.getByTorneo",t);
		}
		session.close();
		return result;
	}
	
	public Integer create(Squadra s){
		session = sessionFactory.openSession();
		session.insert("SquadraMapping.insert",s);
		session.commit();
		session.close();
		return s.getId();
	}
	
	public Squadra read(int id){
		session = sessionFactory.openSession();
		Squadra  result = session.selectOne("SquadraMapping.getById", id);
		session.close();
		return result;
	}
	
	public void update(Squadra s){
		session = sessionFactory.openSession();
		session.update("SquadraMapping.update", s);
		session.commit();
		session.close();
	}
	
	public void delete(Squadra s){
		session = sessionFactory.openSession();
		session.delete("SquadraMapping.delete", s);
		session.commit();
		session.close();
	}
}

