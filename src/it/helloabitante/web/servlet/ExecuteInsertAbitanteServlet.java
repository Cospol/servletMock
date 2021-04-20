package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String codiceFiscale = request.getParameter("codiceFiscaleInput");
		String eta = request.getParameter("etaInput");
		String mottoDiVita = request.getParameter("mottoDiVitaInput");

		if(nome!= null && nome != "" && cognome!= null && cognome != "" 
				&& codiceFiscale!= null && codiceFiscale != "" && eta!= null && eta != "" && mottoDiVita!= null && mottoDiVita != "" ) {
			try {
				Abitante abitanteInstance = new Abitante(nome, cognome, codiceFiscale, Integer.parseInt(eta), mottoDiVita);
				MyServiceFactory.getAbitanteServiceInstance().inserisci(abitanteInstance);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("searchForm.jsp");
			rd.forward(request, response);

		}
			

		
		
	}

}
