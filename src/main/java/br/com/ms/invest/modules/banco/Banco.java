package br.com.ms.invest.modules.banco;

import br.com.ms.invest.utils.AbstractEntity;
import jakarta.persistence.Entity;
@Entity
public class Banco extends AbstractEntity{	
	private static final long serialVersionUID = 1L;
	
	
	
	private String nome;
	private String cnpj;
	private String numero;
	
	public Banco() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	

}
