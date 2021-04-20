package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.Image;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
			return DB_Mock.LISTA_ABITANTI;
		}

	@Override
	public Abitante get(Long id) throws Exception {
		if ( id == null  ||  id <= 0) {
			throw new Exception("input non valido");
		}
		for (Abitante item : DB_Mock.LISTA_ABITANTI) {
			if (item.getIdAbitante().equals(id)) {
		 		return item;
			}
		}
		return null;
	}

	@Override
	public int update(Abitante input) throws Exception {
		if (input == null || input.getIdAbitante() == null || input.getIdAbitante() <= 0) {
			throw new Exception("input non valido");
		}
		for (Abitante item : DB_Mock.LISTA_ABITANTI) {
			if (item.getIdAbitante().equals(input.getIdAbitante())) {
		 		item.setCodiceFiscale(input.getCodiceFiscale());
		 		item.setCognome(input.getCognome());
		 		item.setEta(input.getEta());
		 		item.setNome(input.getNome());
		 		item.setNome(input.getNome());
		 		return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		 
		input.setIdAbitante(DB_Mock.getNexIdAvailable());
		DB_Mock.LISTA_ABITANTI.add(input);
		return 1;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		if (input == null || input.getIdAbitante() == null || input.getIdAbitante() <= 0) {
			throw new Exception("input non valido");
		}
		DB_Mock.LISTA_ABITANTI.remove(input);
		return 1;

	}

}
