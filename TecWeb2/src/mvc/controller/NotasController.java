package mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.*;
@Controller
public class NotasController {
	@RequestMapping("/")

	public String execute() {
		System.out.println("Lógica do MVC");
		return "Notas";
	}
	@RequestMapping("adicionarNota")
	public String adiciona(Notas nota) {
		DAO dao = new DAO();
		dao.adiciona(nota);
		return "Notas";
	}
	@RequestMapping("deletarNota")
	public String remove(Notas nota) {
		DAO dao = new DAO();
		dao.adiciona(nota);
		return "Notas";
	}
	@RequestMapping("editarCor")
	public String alteraCor(Cores cor) {
		DAO dao = new DAO();
		dao.adicionaCor(cor);
		return "Notas";
	}
	@RequestMapping("editarNota")
	public String altera(Notas nota) {
		DAO dao = new DAO();
		dao.adiciona(nota);
		return "Editar";
	}
}