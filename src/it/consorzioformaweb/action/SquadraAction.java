package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SquadraDAO;
import it.consorzioformaweb.model.dao.TorneoDAO;
import it.consorzioformaweb.model.dto.Squadra;
import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SquadraAction extends ActionSupport {
	
	private SquadraDAO squadraDAO;
	private TorneoDAO torneoDAO;

	
	private Squadra squadra;
	private List<Squadra> elenco = new ArrayList<Squadra>();
	private String actionDaInvocare;
	private String id;
	private Integer id_torneo;
	private boolean inserito = false;
	
	private HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	
	public void setSquadraDAO(SquadraDAO squadraDAO) {
		this.squadraDAO = squadraDAO;
	}

	public void setTorneoDAO(TorneoDAO torneoDAO) {
		this.torneoDAO = torneoDAO;
	}
	
	public HashMap<Integer, String> createMap(){
		map = new HashMap<Integer, String>();
		
		List<Torneo> tornei = torneoDAO.search();
		for (Torneo t:tornei){
			map.put(t.getId(), t.getNome());
		}
		
		return map;
	}
	
	public String search() throws IOException{
		createMap();
		if (id_torneo == null)
			elenco = squadraDAO.search();
		else
			elenco = squadraDAO.searchByTorneo(id_torneo);	
		return "success";
	}
	
	
	public String create() throws IOException {
		Torneo t = torneoDAO.read(id_torneo);
		
		squadra.setTorneo(t);
		
		squadraDAO.create(squadra);
		inserito = true;
		return "success";		
	}
	
	public String read() throws IOException{
		createMap();
		actionDaInvocare = "squadraCreateAction";
				
		if (id != null && id.length()>0){
			actionDaInvocare = "squadraUpdateAction";
			squadra = squadraDAO.read(Integer.parseInt(id));
		}
		return "success";
	}
	
	public String delete() throws IOException{
		squadra = squadraDAO.read(Integer.parseInt(id));
		squadraDAO.delete(squadra);
		return "success";
	}
	
	public String update() throws IOException {
		Torneo t = torneoDAO.read(id_torneo);
		
		squadra.setTorneo(t);
		
		squadraDAO.update(squadra);
		return "success";
	}
	
	public void validateCreate(){
		if (squadra.getNome().length() == 0 || squadra.getNome() == null){
			addFieldError("ErroreNome", getText("squadra.nome.required"));
			createMap();
		}
		if (id_torneo == -1){
			addFieldError("ErroreTorneo", "Scegliere il torneo");
			createMap();
		}
	}
	
	public void validateUpdate(){
		if (squadra.getNome().length() == 0 || squadra.getNome() == null){
			addFieldError("ErroreNome", getText("squadra.nome.required"));
			createMap();
		}
		if (id_torneo == -1){
			addFieldError("ErroreTorneo", "Scegliere il torneo");
			createMap();
		}

	}
	
	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public List<Squadra> getElenco() {
		return elenco;
	}

	public void setElenco(List<Squadra> elenco) {
		this.elenco = elenco;
	}

	public String getActionDaInvocare() {
		return actionDaInvocare;
	}

	public void setActionDaInvocare(String actionDaInvocare) {
		this.actionDaInvocare = actionDaInvocare;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}
	public Integer getId_torneo() {
		return id_torneo;
	}
	public void setId_torneo(Integer id_torneo) {
		this.id_torneo = id_torneo;
	}
	public boolean isInserito() {
		return inserito;
	}
	public void setInserito(boolean inserito) {
		this.inserito = inserito;
	}
}
