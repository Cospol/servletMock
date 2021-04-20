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
 * Servlet implementation class PrepareUpdateAbitanteServlet
 */
@WebServlet("/PrepareUpdateAbitanteServlet")
public class PrepareUpdateAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PrepareUpdateAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdDellAbitanteCheStringVoglioModificare = request.getParameter("idDaInviareComeParametro");
		
	 	AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();
	 	Abitante result = null;
	 	try {
			  result = abitanteServiceInstance.caricaSingoloElemento(Long.parseLong(parametroIdDellAbitanteCheStringVoglioModificare)) ;
			
	 	} catch (NumberFormatException e) {
	 		e.printStackTrace();
		} catch (Exception e) {
	 		e.printStackTrace();
		}
	 	
		 request.setAttribute("abitanteDaInviareAPaginaModifica", result);
		 //response.getWriter().append("Volevi visualizzare abitante con id: "+parametroIdDellAbitanteDiCuiVoglioIlDettaglio );
		 RequestDispatcher rd = request.getRequestDispatcher("modifica.jsp");
		 rd.forward(request, response);
	}
	 

	 

}
