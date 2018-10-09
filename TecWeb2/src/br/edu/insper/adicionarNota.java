package br.edu.insper;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adicionarNota
 */
@WebServlet("/adicionarNota")
public class adicionarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adicionarNota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	//PrintWriter out = response.getWriter ();
    	
    	DAO dao = new DAO();
    	
    	String nova_nota = request.getParameter("nota");
    	String novo_titulo = request.getParameter("titulo");
    	String nova_cor = request.getParameter("cor");
    	Cores cor = new Cores();
    	Notas nota = new Notas();
    	nota.setTitulo(novo_titulo);
    	nota.setNota(nova_nota);
    	cor.setCor(nova_cor);
    	
    	dao.adiciona(nota);
    	int nota_id = dao.getId1();
    	cor.setIdNota(nota_id);
    	System.out.println("id_nota" + nota_id);
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
