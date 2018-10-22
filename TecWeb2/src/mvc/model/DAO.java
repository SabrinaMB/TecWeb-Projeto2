package mvc.model;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.GsonBuilder;


public class DAO {
	
	private Connection connection = null;
	
	public DAO() {
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(
					 "jdbc:mysql://localhost/infinitynote", "root", "Manu_6006"); // MUDAR!!!!!!!!!!
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Não rolou o try1 class");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Não rolou o try1 SQL");
		}
	}
	public List<Notas> getLista(){
		
		List<Notas> notas = new ArrayList<Notas>();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM Notas");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setId(rs.getInt("id"));
				nota.setTitulo(rs.getString("titulo"));
				nota.setNota(rs.getString("nota"));
				
				// SELECT id FROM cor WHERE nota.id = cor.nota_id
				// se der null coloca cor defaul
				// se retornar coloca a cor encontrada
				// setcor
				
				
				notas.add(nota);
			}
			String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                    create().toJson(notas);
		try {
			FileWriter file = new FileWriter("/Users/sabrinamachado/Documents/4o.\\ Semestre/TecWeb/TecWeb-Projeto2/TecWeb/WebContent/resources/script/info.json");
			file.write(json);
			System.out.println("deu certo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			System.out.println(json);
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notas;
	}
	
	public void altera(String titulo, String nota, int id, String cor) {
		try {
			String sql = "UPDATE Notas SET " +
					"titulo=?, nota=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, titulo);
			stmt.setString(2, nota);
			stmt.setInt(3, id);
			stmt.execute();
			stmt.close();
			alteraCor(cor, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adiciona(String titulo, String nota, String cor, String font) {
		try {
			
			String sql = "INSERT INTO Notas" +
			"(titulo,nota,font) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,titulo);
			stmt.setString(2,nota);
			stmt.setString(3,font);
			stmt.execute();
			stmt.close();
			adicionaCor(cor, getId1());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection
			 .prepareStatement("DELETE FROM Notas WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId1() {
		
		int id = 0;
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT max(id) AS id FROM notas");
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("id");
				
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	public void close() {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public List<Cores> getListaCor() {
		
		List<Cores> cores = new ArrayList<Cores>();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM cor");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cores cor = new Cores();
				cor.setId(rs.getInt("id"));
				cor.setIdNota(rs.getInt("nota_id"));
				cor.setCor(rs.getString("cor"));
				cores.add(cor);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cores;
	}
	public String getCor1(Integer id) {
		
		String cor = new String();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT cor FROM cor WHERE nota_id = ?");
			stmt.setLong(1,id);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cores cor1 = new Cores();
				cor1.setCor(rs.getString("cor"));
				cor = cor1.getCor();
				
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cor;
	}
	public String getFont(Integer id) {
		
		String fonte = new String();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT font FROM notas WHERE id = ?");
			stmt.setLong(1,id);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Fontes font = new Fontes();
				font.setFont(rs.getString("font"));
				fonte = font.getFont();
				
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fonte;
	}
	public void alteraCor(String cor, int id) {
		try {
			String sql = "UPDATE cor SET " +
					"cor=? WHERE nota_id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cor);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adicionaCor(String cor, Integer id) {
		try {
			if (cor == null) {
				cor = "#000000";
			}
			String sql = "INSERT INTO cor" +
			"(nota_id,cor) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.setString(2,cor);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeCor(Integer nota_id) {
		try {
			PreparedStatement stmt = connection
			 .prepareStatement("DELETE FROM cor WHERE nota_id=?");
			stmt.setLong(1, nota_id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alteraFont(String font, int id) {
		try {
			if(font == null) {
				font = "Nunito";
			}
			String sql = "UPDATE Notas SET " +
					"font=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, font);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public String getFont1(Integer id) {
		
		String font = new String();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT font FROM notas WHERE id = ?");
			stmt.setLong(1,id);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				font = rs.getString("font");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return font;
	}

}

