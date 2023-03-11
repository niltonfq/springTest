package br.com.ms.invest.modules.dominio;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dominio {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private BigInteger id;
	
	private String tabela;
	private String campo;
	private String valor;
	private String descricao;
	private Integer ordem;
	
	public Dominio() {
		super();
	}

	public Dominio(BigInteger id, String tabela, String campo, String valor, String descricao) {
		super();
		this.id = id;
		this.tabela = tabela;
		this.campo = campo;
		this.valor = valor;
		this.descricao = descricao;
	}



	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	
	
	

}
