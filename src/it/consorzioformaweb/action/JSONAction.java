package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SocietaDAO;
import it.consorzioformaweb.model.dao.SquadraDAO;
import it.consorzioformaweb.model.dao.TorneoDAO;
import it.consorzioformaweb.model.dao.impl.AtletaMyBatisDAO;
import it.consorzioformaweb.model.dto.Atleta;
import it.consorzioformaweb.model.dto.ParameterObject;
import it.consorzioformaweb.model.dto.Societa;
import it.consorzioformaweb.model.dto.Squadra;
import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.util.List;
/**
 * Classe che restituisce i dati delle varie classi di modello
 * (Torneo, Squadra, Societa) in formato JSON
 * @author Corso
 *
 */
public class JSONAction {

	private Squadra squadra;
	private Torneo torneo;
	private Atleta atleta;
	private Societa societa;
	
	private int id_societa;
	private TorneoDAO torneoDAO;
	private SquadraDAO squadraDAO;
	private SocietaDAO societaDAO;
	private ParameterObject po;
	private List<Squadra> squadre;	
	private List<Societa> societas;
	private List<Torneo> tornei;
	private List<Atleta> atleti;
	
	
	public String torneiJSON() throws IOException{
				tornei = torneoDAO.search();
		return "success";
	}

	public String squadreJSON() throws IOException{
		
		if (torneo != null &&
		torneo.getId() != -1)
		{
			squadre = squadraDAO.searchByTorneo(torneo.getId());
		} 
		else
		{
			squadre = squadraDAO.search();
		}
		
		return "success";
	}
	
	public String atletiJSON() throws IOException{
		AtletaMyBatisDAO dao = new AtletaMyBatisDAO();
		
		if (id_societa != 0 &&
				id_societa != -1)
		{	
			atleti = dao.searchByIdSocieta(societa.getId());
		}
		else
			atleti = dao.search();
		return "success";
	}
	
	public String atletiJSONNew() throws IOException{
		AtletaMyBatisDAO dao = new AtletaMyBatisDAO();
		atleti = dao.searchByAll(po);
		return "success";
	}
	
	public String societaJSON() throws IOException{		
		if (torneo!=null &&
		torneo.getId() != -1)
		{
			societas = societaDAO.searchBySquadra(squadra.getId());
		} 
		else
		{
			societas = societaDAO.search();
		}
		
		return "success";
	}
	
	
	// Costruttori
	
	
	public List<Societa> getSocietas() {
		return societas;
	}

	public void setSocietas(List<Societa> societas) {
		this.societas = societas;
	}

	public List<Torneo> getTornei() {
		return tornei;
	}

	public void setTornei(List<Torneo> tornei) {
		this.tornei = tornei;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
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

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public List<Atleta> getAtleti() {
		return atleti;
	}

	public void setAtleti(List<Atleta> atleti) {
		this.atleti = atleti;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public int getId_societa() {
		return id_societa;
	}

	public void setId_societa(int id_societa) {
		this.id_societa = id_societa;
	}

	public ParameterObject getPo() {
		return po;
	}

	public void setPo(ParameterObject po) {
		this.po = po;
	}

	public void setTorneoDAO(TorneoDAO torneoDAO) {
		this.torneoDAO = torneoDAO;
	}

	public void setSquadraDAO(SquadraDAO squadraDAO) {
		this.squadraDAO = squadraDAO;
	}

	public void setSocietaDAO(SocietaDAO societaDAO) {
		this.societaDAO = societaDAO;
	}
	
	
}
