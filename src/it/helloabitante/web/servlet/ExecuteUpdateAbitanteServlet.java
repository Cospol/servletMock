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

/**
 * Servlet implementation class ExecuteUpdateAbitanteServlet
 */
@WebServlet("/ExecuteUpdateAbitanteServlet")
public class ExecuteUpdateAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteUpdateAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idInput");
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String codiceFiscale = request.getParameter("codiceFiscaleInput");
		String eta = request.getParameter("etaInput");
		String mottoDiVita = request.getParameter("mottoDiVitaInput");
		Abitante abitanteInstance = null;
		if( id != null && id != "" && nome!= null && nome != "" && cognome!= null && cognome != "" 
				&& codiceFiscale!= null && codiceFiscale != "" && eta!= null && 
				eta != "" && mottoDiVita!= null && mottoDiVita != "" ) {
			try {
				abitanteInstance = new Abitante(Long.parseLong(id),nome, cognome, codiceFiscale, Integer.parseInt(eta), mottoDiVita);
				MyServiceFactory.getAbitanteServiceInstance().aggiorna(abitanteInstance);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("searchForm.jsp");
			rd.forward(request, response);
		}
		else {
			abitanteInstance = new Abitante(Long.parseLong(id),nome,cognome,codiceFiscale,Integer.parseInt(eta),mottoDiVita);
			request.setAttribute("abitanteDaInviareAPaginaModifica", abitanteInstance);
			RequestDispatcher rd = request.getRequestDispatcher("modifica.jsp");
			rd.forward(request, response);
		}

		//response.getWriter().append("Volevi visualizzare abitante con id: "+parametroIdDellAbitanteDiCuiVoglioIlDettaglio );

	}

}
