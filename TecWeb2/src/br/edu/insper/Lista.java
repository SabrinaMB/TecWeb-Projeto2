package br.edu.insper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/lista")
public class Lista extends HttpServlet {
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
		throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		List<Notas> notas = dao.getLista();
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body><table border='1'>");
			out.println("<tr><td>ID</td><td>Nome</td>" +
					"<td>Altura</td></tr>");
			for (Notas nota : notas) {
				 out.println("<tr><td>" + nota.getId() + "</td>");
				 out.println("<td>" + nota.getTitulo() + "</td>");
				 out.println("<td>" + nota.getNota() + "</td></tr>");
			}
			out.println("</table></body></html>");
			
			dao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 }
}