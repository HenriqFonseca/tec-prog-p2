package model;

import java.util.ArrayList;

import project.dao.TarefaDAO;

public class Tarefa {
	private int idTarefa;
	private String titulo;
	private String descricao;
	private String status;
	private int idAluno;
	
	
	public Tarefa(){}
	
	public Tarefa(String titulo, String descricao, String status, int idAluno) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.idAluno = idAluno;	
	}
	
	public Tarefa(int idTarefa, String titulo, String dataFinal, String descricao, String status, int idAluno) {
		this.idTarefa = idTarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.idAluno = idAluno;
	}

	
	public void deletarTarefa(int id) {
		new TarefaDAO().deletarTarefa(id);
	}
	
	public void salvar() {
		new TarefaDAO().criarTarefa(this);
	}
	
	public ArrayList<Tarefa> buscarTarefaPorId(int id){
		return new TarefaDAO().buscarTarefasPorId(id);
	}
	
	
	public int getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	@Override
	public String toString() {
		return "Tarefa [idTarefa=" + idTarefa + ", titulo=" + titulo + ", dataFinal=" + ", descricao="
				+ descricao + ", status=" + status + ", idAluno=" + idAluno + "]";
	}

	
	
	

	
	
}
