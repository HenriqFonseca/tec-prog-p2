package model;

import java.util.ArrayList;

import project.dao.AlunoDAO;

public class Aluno {
	private int IdAluno;
	private String nome;
	private String email;
	private String senha;
	
	public Aluno() {}
	
	public Aluno(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Aluno(int IdAluno, String nome, String email, String senha) {
		this.IdAluno = IdAluno;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	
	
	public int getIdAluno() {
		return IdAluno;
	}

	public void setIdAluno(int idAluno) {
		IdAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void salvar() {
		new AlunoDAO().cadastrarAluno(this);
	}
	
	public ArrayList<Aluno> BuscarAlunoPorNome(String nome){
		return new AlunoDAO().BuscarAlunoPorNome(nome);
	}

	public Aluno BuscarAlunoPorId(int id){
		return new AlunoDAO().buscarAlunoPorId(id);
	}
	
	public boolean Login (String email, String senha) {
		return new AlunoDAO().Login(email, senha);
	}
	
	public Aluno buscarAlunoPorEmail(String email) {
		return new AlunoDAO().buscarAlunoPorEmail(email);
	}
	
	@Override
	public String toString() {
		return "Aluno [IdAluno=" + IdAluno + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	
	
	
}
