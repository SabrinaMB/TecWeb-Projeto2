package br.edu.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	
	private Connection connection = null;
	
	public DAO() {
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(
					 "jdbc:mysql://localhost/infinitynote", "root", "Ratoeira9804"); // MUDAR!!!!!!!!!!
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
	public List<Notas> getLista() {
		
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
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notas;
	}
	public void altera(Notas nota) {
		try {
			String sql = "UPDATE Notas SET " +
					"titulo=?, nota=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getTitulo());
			stmt.setString(2, nota.getNota());
			stmt.setInt(3, nota.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adiciona(Notas nota) {
		try {
			String sql = "INSERT INTO Notas" +
			"(titulo,nota) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,nota.getTitulo());
			stmt.setString(2,nota.getNota());
			stmt.execute();
			stmt.close();
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
	public void alteraCor(Cores cor) {
		try {
			String sql = "UPDATE cor SET " +
					"cor=? WHERE nota_id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cor.getCor());
			stmt.setInt(2, cor.getIdNota());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adicionaCor(Cores cor) {
		try {
			String sql = "INSERT INTO cor" +
			"(nota_id,cor) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,cor.getIdNota());
			stmt.setString(2,cor.getCor());
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

}

