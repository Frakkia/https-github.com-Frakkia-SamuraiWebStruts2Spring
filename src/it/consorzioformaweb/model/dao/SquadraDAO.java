package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Squadra;

import java.util.List;

public interface SquadraDAO {

	public List<Squadra> search();
	
	public Integer create(Squadra squadra);
	
	public Squadra read(int id);
	
	public void update(Squadra squadra);
	
	public void delete(Squadra squadra);

	public List<Squadra> searchByTorneo(Integer id_torneo);
}