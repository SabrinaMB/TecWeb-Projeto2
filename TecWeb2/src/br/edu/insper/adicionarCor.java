package br.edu.insper;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adicionarCor
 */
@WebServlet("/adicionarCor")
public class adicionarCor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adicionarCor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	//PrintWriter out = response.getWriter ();
    	DAO dao = new DAO();
    	
    	String nova_cor = request.getParameter("cor");
    	String nota_id = request.getParameter("nota_id");
    	Cores cor = new Cores();
    	cor.setCor(nova_cor);
    	cor.setIdNota(Integer.parseInt(nota_id));
    	dao.adicionaCor(cor);
    	
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

	}

}
