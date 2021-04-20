package it.helloabitante.service.abitante;

import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public Abitante caricaSingoloElemento(Long id) throws Exception {
		return abitanteDAO.get(id);
	}

	@Override
	public List<Abitante> listAll()  throws Exception{
		return abitanteDAO.list();
	}

	@Override
	public int aggiorna(Abitante abitanteInput) throws Exception {
		return abitanteDAO.update(abitanteInput);
 	}

	@Override
	public int inserisci(Abitante abitanteInput) throws Exception {
		return abitanteDAO.insert(abitanteInput);
	}

	@Override
	public int elimina(Abitante abitanteInput) throws Exception {
		return abitanteDAO.delete(abitanteInput) ;
	}

	
}
