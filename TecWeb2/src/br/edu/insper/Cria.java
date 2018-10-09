package br.edu.insper;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cria")
public class Cria extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	out.println("<html><body>");
	out.println("<form method='post'>");
	out.println("Titulo: <input type='text' name='titulo'><br>");
	out.println("Nota: <input type='text' name='nota' step='0.01'><br>");
	out.println("<input type='submit' value='Submit'>");
	out.println("</form>");
	out.println("<body><html>");
	}
	
	@Override
	 protected void doPost(HttpServletRequest request,
			 				HttpServletResponse response)
			 throws ServletException, IOException {
		 
		 DAO dao = new DAO();
	 
		 Notas nota = new Notas();
		 nota.setTitulo(request.getParameter("titulo"));
		 nota.setNota(request.getParameter("nota"));
		 

		 dao.adiciona(nota);
		 
		 PrintWriter out = response.getWriter();
		 out.println("<html><body>");
		 out.println("adicionado" + nota.getTitulo());
		 out.println("</body></html>");
		 
		 dao.close();
		 }
}