package br.edu.insper;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editarNota
 */
@WebServlet("/editarNota")
public class editarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarNota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	//PrintWriter out = response.getWriter ();
    	DAO dao = new DAO();
    	
    
    	
    	int novo_id = Integer.parseInt(request.getParameter("id"));
    	String nova_nota = request.getParameter("nota");
    	String novo_titulo = request.getParameter("titulo");
    	String nova_cor = request.getParameter("cor");
    	Notas nota = new Notas();
    	Cores cor = new Cores();
    	nota.setTitulo(novo_titulo);
    	nota.setNota(nova_nota);
    	nota.setId(novo_id);
    	cor.setCor(nova_cor);
    	cor.setIdNota(novo_id);
    	dao.altera(nota);
    	dao.alteraCor(cor);
    	
    	
    	
    	String nextJSP = "/Notas.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    	dispatcher.forward(request,response);
    	
    	

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
