package br.edu.insper;

public class Notas {
	private Integer id;
	private String titulo;
	private String nota;
	private String cor;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getTitulo() {return this.titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	
	public String getNota() {return this.nota;}
	
	public void setNota(String nota) {this.nota = nota;}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

}