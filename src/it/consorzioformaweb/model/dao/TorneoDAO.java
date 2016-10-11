package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Torneo;

import java.util.List;

public interface TorneoDAO {

	public List<Torneo> search();
	
	public Integer create(Torneo torneo);
	
	public Torneo read(int id);
	
	public void update(Torneo torneo);
	
	public void delete(Torneo torneo);
	
	
}
