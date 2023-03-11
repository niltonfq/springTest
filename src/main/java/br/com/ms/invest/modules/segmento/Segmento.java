package br.com.ms.invest.modules.segmento;

import br.com.ms.invest.utils.AbstractEntity;
import jakarta.persistence.Entity;
@Entity
public class Segmento extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public Segmento() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

}
