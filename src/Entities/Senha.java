package Entities;

public class Senha {
	
	private int tamanhoMin;
	private int tamanhoMax;
	private String senha;
	private String numeroSenha;
	private String senhaMaiusc;
	private String senhaMinusc;
	private String caracEspe;
	
	
	public int getTamanhoMin() {
		return tamanhoMin;
	}
	
	public void setTamanhoMin(int tamanhoMin) {
		this.tamanhoMin = tamanhoMin;
	}
	
	public int getTamanhoMax() {
		return tamanhoMax;
	}
	
	public void setTamanhoMax( int tamanhoMax) {
		this.tamanhoMax = tamanhoMax;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNumeroSenha() {
		return numeroSenha;
	}
	
	public void setNumeroSenha(String numeroSenha) {
		this.numeroSenha = numeroSenha;
	}
	
	public String getSenhaMaiusc() {
		return senhaMaiusc;
	}
	
	public void setSenhaMaiusc(String senhaMaiusc) {
		this.senhaMaiusc = senhaMaiusc;
	}

	public String getSenhaMinusc() {
		return senhaMinusc;
	}
	
	public void setSenhaMinusc(String senhaMinusc) {
		this.senhaMinusc = senhaMinusc;
	}
	
	public String getCaracEspe() {
		return caracEspe;
	}
	
	public void setCaracEspe(String caracEspe) {
		this.caracEspe = caracEspe;
	}
}
