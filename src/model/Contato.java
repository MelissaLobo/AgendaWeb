package model;

public class Contato {

	//Contato da agenda

	private Long id;
	private String nome;
	private String telefone;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Contato outroContato=(Contato)obj;
		return this.id.equals(outroContato.id);
	}

	public String toString() {
		return "  \n nome:"+ nome + " \n telefone:"+telefone;
	}
}