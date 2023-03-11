package br.com.ms.invest.modules.tipoAtivo;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class TipoAtivo {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)    
	private BigInteger id;
	
	private String nome;
	private String fixaVariavel;
	private Integer risco;
	
	public TipoAtivo() {}
	
	public TipoAtivo(BigInteger id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFixaVariavel() {
		return fixaVariavel;
	}

	public void setFixaVariavel(String fixaVariavel) {
		this.fixaVariavel = fixaVariavel;
	}

	public Integer getRisco() {
		return risco;
	}

	public void setRisco(Integer risco) {
		this.risco = risco;
	}
	
	
	

}






