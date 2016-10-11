package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SquadraDAO;
import it.consorzioformaweb.model.dto.Squadra;

import java.io.IOException;
import java.util.List;

public class SquadraJSONAction {

	private SquadraDAO squadraDAO;


	private Squadra squadra;
	private List<Squadra> squadre;
	
	public void setSquadraDAO(SquadraDAO squadraDAO) {
		this.squadraDAO = squadraDAO;
	}
	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	
	public List<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(List<Squadra> squadre) {
		this.squadre = squadre;
	}
	
	public String execute() throws IOException{
		if (squadra!=null && squadra.getTorneo() != null &&
				squadra.getTorneo().getId() != null &&
				squadra.getTorneo().getId() != -1){
			squadre = squadraDAO.searchByTorneo(squadra.getTorneo().getId());
		} else {
			squadre = squadraDAO.search();
		}
		return "success";
	}
}
