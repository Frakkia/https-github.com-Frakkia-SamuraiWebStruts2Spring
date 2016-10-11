package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SocietaDAO;
import it.consorzioformaweb.model.dao.SquadraDAO;
import it.consorzioformaweb.model.dto.Societa;
import it.consorzioformaweb.model.dto.Squadra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SocietaAction extends ActionSupport {

	private Societa societa;
	private SocietaDAO societaDAO;
	private SquadraDAO squadraDAO;
	private List<Societa> elenco = new ArrayList<Societa>();
	private String actionDaInvocare;
	private HashMap<Integer, String> map = new HashMap<Integer, String>();
	private Integer id_squadra;
	private String id;
	private String start;
	private String startText;

	public HashMap<Integer, String> createMap() {
		map = new HashMap<Integer, String>();
		List<Squadra> squadre = squadraDAO.search();
		for (Squadra s : squadre) {
			map.put(s.getId(), s.getNome());
		}

		return map;
	}

	public String search() throws IOException {
		createMap();
		if (id_squadra == null)
			setElenco(societaDAO.search());
		else
			setElenco(societaDAO.searchBySquadra(id_squadra));
		return "success";
	}

	public String create() throws IOException {
		Squadra s = squadraDAO.read(id_squadra);
		societa.setSquadra(s);
		societaDAO.create(societa);
		return "success";
	}

	public String read() throws IOException {
		createMap();
		start = "-1";
		startText = getText("societa.squadra.tutti");
		setActionDaInvocare("societaCreateAction");

		if (id != null && id.length() > 0) {
			setActionDaInvocare("societaUpdateAction");
			societa = societaDAO.read(Integer.parseInt(id));
			start = societa.getSquadra().getId().toString();
			startText = societa.getSquadra().getNome();
		}
		return "success";
	}

	public String delete() throws IOException {
		societa = societaDAO.read(Integer.parseInt(id));
		societaDAO.delete(societa);
		return "success";
	}

	public String update() throws IOException {
		Squadra s = squadraDAO.read(id_squadra);
		societa.setSquadra(s);
		societaDAO.update(societa);
		return "success";
	}

	public void validateCreate() {
		if (societa.getNome().length() == 0 || societa.getNome() == null) {
			addFieldError("ErroreNome", getText("societa.nome.required"));
			createMap();
		}
		if (id_squadra == -1) {
			addFieldError("ErroreSquadra", "Scegliere la squadra");
			createMap();
		}
	}

	public void validateUpdate() {
		if (societa.getNome().length() == 0 || societa.getNome() == null) {
			addFieldError("ErroreNome", getText("societa.nome.required"));
			createMap();
		}
		if (id_squadra == -1) {
			addFieldError("ErroreSquadra", "Scegliere la squadra");
			createMap();
		}

	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}

	public Integer getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(Integer id_squadra) {
		this.id_squadra = id_squadra;
	}

	public List<Societa> getElenco() {
		return elenco;
	}

	public void setElenco(List<Societa> elenco) {
		this.elenco = elenco;
	}

	public String getActionDaInvocare() {
		return actionDaInvocare;
	}

	public void setActionDaInvocare(String actionDaInvocare) {
		this.actionDaInvocare = actionDaInvocare;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStartText() {
		return startText;
	}

	public void setStartText(String startText) {
		this.startText = startText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSocietaDAO(SocietaDAO societaDAO) {
		this.societaDAO = societaDAO;
	}

	public void setSquadraDAO(SquadraDAO squadraDAO) {
		this.squadraDAO = squadraDAO;
	}

}
