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
import it.helloabitante.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteDeleteAbitanteServlet
 */
@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteDeleteAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdDellAbitanteCheVoglioEliminare = request.getParameter("idDaInviareComeParametro");
		try {
			AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
			Abitante abitante = abitanteService.caricaSingoloElemento(Long.parseLong(parametroIdDellAbitanteCheVoglioEliminare));
			abitanteService.elimina(abitante);
			RequestDispatcher rd = request.getRequestDispatcher("searchForm.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	 

}
