package mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.*;
@Controller
public class NotasController {
	@RequestMapping("/")

	public String execute() {
		System.out.println("Lógica do MVC");
		return "Notas";
	}
	@RequestMapping("entrarNota")
	public String form() {
		return "Notas";
	}
	@RequestMapping("adicionarNota")
	public String adiciona(@RequestParam(value = "titulo") String titulo, @RequestParam(value = "nota") String nota, @RequestParam(value = "cor") String cor, @RequestParam(value = "cor") String font) {
		DAO dao = new DAO();
		dao.adiciona(titulo, nota, cor, font);
		return "Notas";
	}
	@RequestMapping("deletarNota")
	public String remove(@RequestParam(value = "id") Integer notaId) {
		DAO dao = new DAO();
		dao.remove(notaId);
		return "Notas";
	}
	@RequestMapping("editarCor")
	public String alteraCor(@RequestParam(value = "cor") String cor,@RequestParam(value = "nota_id") Integer id) {
		DAO dao = new DAO();
		dao.alteraCor(cor, id);
		return "Notas";
	}
	@RequestMapping("adicionarCor")
	public String adiciona(@RequestParam(value = "cor") String cor,@RequestParam(value = "nota_id") Integer id) {
		DAO dao = new DAO();
		dao.adicionaCor(cor, id);
		return "Notas";
	}
	@RequestMapping("pegarLista")
	public String getLista(Cores cor) {
		DAO dao = new DAO();
		dao.getLista();
		return "Notas";
	}
	@RequestMapping("alteraFont")
	public String alteraFont(@RequestParam(value = "nota_id") Integer id, @RequestParam(value = "font") String font) {
		DAO dao = new DAO();
		dao.alteraFont(font, id);
		return "Notas";
	}
	@RequestMapping("editarNota")
	public String altera(@RequestParam(value = "titulo") String titulo, @RequestParam(value = "nota") String nota, @RequestParam(value = "id") Integer id,@RequestParam(value = "cor") String cor) {
		DAO dao = new DAO();
		dao.altera(titulo, nota, id, cor);
		return "Edita";
	}
	@RequestMapping("editarNota2")
	public String altera2(@RequestParam(value = "titulo") String titulo, @RequestParam(value = "nota") String nota, @RequestParam(value = "id") Integer id,@RequestParam(value = "cor") String cor) {
		DAO dao = new DAO();
		dao.altera(titulo, nota, id, cor);
		return "Notas";
	}
}