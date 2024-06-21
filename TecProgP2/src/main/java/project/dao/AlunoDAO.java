package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletResponse;
import model.Aluno;

public class AlunoDAO {
	
	public boolean Login(String email, String senha) {
		String sql = "SELECT * FROM alunos WHERE email = ? AND senha = ?";
		PreparedStatement pStatement =null;
		Connection conn = null;
		Aluno aluno = null;
		ResultSet rs = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, email);
			pStatement.setString(2, senha);
			rs = pStatement.executeQuery();
			
			if(rs!=null && rs.next()) {
				aluno = new Aluno();
				aluno.setIdAluno(rs.getInt("idAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSenha(rs.getString("senha"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	
	public Aluno buscarAlunoPorId(int id) {
		String sql = "SELECT * FROM alunos WHERE idAluno = ?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pStatement =null;
		Aluno aluno = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			if(rs!=null && rs.next()) {
				aluno = new Aluno();
				aluno.setIdAluno(rs.getInt("idAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return aluno;
		
	}
	
	public Aluno buscarAlunoPorEmail(String email) {
		String sql = "SELECT * FROM alunos WHERE email = ?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pStatement =null;
		Aluno aluno = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, email);
			rs = pStatement.executeQuery();
			if(rs!=null && rs.next()) {
				aluno = new Aluno();
				aluno.setIdAluno(rs.getInt("idAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSenha(rs.getString("senha"));
				return aluno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return aluno;
		
	}
	
	
	public void cadastrarAluno(Aluno aluno) {
		String sql = "INSERT INTO alunos VALUES (null,?,?,?)";
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		Connection conn = null;
		
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1,aluno.getNome());
			pStatement.setString(2,aluno.getEmail());
			pStatement.setString(3,aluno.getSenha());
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<Aluno> BuscarAlunoPorNome(String nome){
		String sql = "SELECT * FROM alunos WHERE nome LIKE '%"+nome+"%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Aluno aluno = null;
		ArrayList<Aluno> alunos = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if(rs!=null) {
				alunos = new ArrayList<Aluno>();
				while(rs.next()) {
					aluno = new Aluno();
					aluno.setIdAluno(rs.getInt("idAluno"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setSenha(rs.getString("senha"));
					alunos.add(aluno);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return alunos;
	}
}
