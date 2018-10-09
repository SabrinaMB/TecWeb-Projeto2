package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adicionarNota
 */
@WebServlet("/deletarCor")
public class deletarCor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletarCor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	//PrintWriter out = response.getWriter ();
    	DAO dao = new DAO();
  
    	int nota_id = Integer.parseInt(request.getParameter("nota_id"));
//    	System.out.println(id);
    	dao.removeCor(nota_id);
//    	out.println("<html>");
//    	out.println("<body>");
//    	out.println("Deletou");
//    	out.println("</body>");
//    	out.println("</html>");
    	
    	request.setAttribute("nota_id", nota_id);
		request.getRequestDispatcher("Notas.jsp").forward(request, response);
    	
    	
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter ();
    	DAO dao = new DAO();
    	
    	String ids = request.getParameter("id");
    	int id = Integer.parseInt(ids);
    	dao.remove(id);
    	
    	out.println("<html>");
    	out.println("<body>");
    	out.println("Deletou");
    	out.println("</body>");
    	out.println("</html>");
	}

}
