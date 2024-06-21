package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.Tarefa;

public class TarefaDAO {

	public void deletarTarefa(int id) {
		String sql = "DELETE FROM tarefas WHERE idTarefa = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1,id);
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
	
	public ArrayList<Tarefa> buscarTarefasPorId(int id){
		String sql = "SELECT * FROM tarefas WHERE idAluno = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Tarefa tarefa = null;
		ArrayList<Tarefa> tarefas = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1,id);
			rs = pStatement.executeQuery();  
			if(rs!=null) {
				tarefas = new ArrayList<Tarefa>();
				while(rs.next()) {
					tarefa = new Tarefa();
					tarefa.setIdTarefa(rs.getInt("idTarefa"));
					tarefa.setTitulo(rs.getString("titulo"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setStatus(rs.getString("status"));
					tarefa.setIdAluno(rs.getInt("idAluno"));
					tarefas.add(tarefa);
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
		
		return tarefas;
	}
	
	
	public void criarTarefa(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1,tarefa.getTitulo());
			pStatement.setString(2,tarefa.getDescricao());
			pStatement.setString(3,tarefa.getStatus());
			pStatement.setInt(4,tarefa.getIdAluno());
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
	
}
