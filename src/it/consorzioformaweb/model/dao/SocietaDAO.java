package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Societa;

import java.util.List;

public interface SocietaDAO {

	public List<Societa> search();
	
	public Integer create(Societa squadra);
	
	public Societa read(int id);
	
	public void update(Societa squadra);
	
	public void delete(Societa squadra);

	public List<Societa> searchBySquadra(Integer id_squadra);
}
