package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Atleta;
import it.consorzioformaweb.model.dto.ParameterObject;

import java.util.List;

public interface AtletaDAO {
	
public List<Atleta> search();
	
	public Integer create(Atleta squadra);
	
	public Atleta read(int id);
	
	public void update(Atleta squadra);
	
	public void delete(Atleta squadra);

	public List<Atleta> searchByIdSocieta(Integer id);

	public List<Atleta> searchByAll(ParameterObject po);
}
