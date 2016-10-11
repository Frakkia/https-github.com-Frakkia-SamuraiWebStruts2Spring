package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.TorneoDAO;
import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TorneoAction extends ActionSupport {

	private TorneoDAO torneoDAO;
	private Torneo torneo;
	private List<Torneo> elenco = new ArrayList<Torneo>();
	private String actionDaInvocare;
	// campo che viene inviato dalla pagina di lista per la modifica o
	// cancellazione
	private String id;

	public String search() throws IOException {
		elenco =
				torneoDAO.search();
		return "success";
	}

	public String create() throws IOException {
		torneoDAO.create(torneo);
		return "success";
	}

	public String read() throws IOException {
		actionDaInvocare = "torneoCreateAction";
		if (id != null && id.length() > 0) {
			actionDaInvocare = "torneoUpdateAction";
			torneo = torneoDAO.read(Integer.parseInt(id));
		}
		return "success";
	}

	public String delete() throws IOException {
		torneo = torneoDAO.read(Integer.parseInt(id));
		torneoDAO.delete(torneo);
		return "success";
	}

	public String update() throws IOException {
		torneoDAO.update(torneo);
		return "success";
	}

	public List<Torneo> getElenco() {
		return elenco;
	}

	public void setElenco(List<Torneo> elenco) {
		this.elenco = elenco;
	}

	public void validateCreate() {
		if (torneo.getNome().length() == 0 || torneo.getNome() == null) {
			addFieldError("ErroreNome", "nome obbligatorio");
		}
		try {
			if (torneo.getAnnoEdizione().toString().length() != 4) {
				addFieldError("ErroreAnno", "L'anno deve dessere di 4 cifre");
			}
		} catch (Exception e) {
			addFieldError("ErroreAnno", "Anno obbligatorio");
		}
	}

	public void validateUpdate() {

		try {
			if (torneo.getId() == null || torneo.getId().toString().equals("")) {
				addFieldError("ErroreID", "Errore ID");
			}
		} catch (Exception e) {
			addFieldError("ErroreAnno", "L'anno deve dessere di 4 cifre");
		}
		validateCreate();
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
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

	/**
	 * @param torneoDAO
	 *            the torneoDAO to set
	 */
	public void setTorneoDAO(TorneoDAO torneoDAO) {
		this.torneoDAO = torneoDAO;
	}
}
