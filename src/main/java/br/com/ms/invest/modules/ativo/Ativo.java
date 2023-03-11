package br.com.ms.invest.modules.ativo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ms.invest.modules.banco.Banco;
import br.com.ms.invest.modules.dominio.Dominio;
import br.com.ms.invest.modules.grupoUsuaria.GrupoUsuaria;
import br.com.ms.invest.modules.segmento.Segmento;
import br.com.ms.invest.modules.tipoAtivo.TipoAtivo;
import br.com.ms.invest.utils.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"grupoUsuariaId", "codigo" }) })
public class Ativo extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tipoativoid", nullable = false)
	private TipoAtivo tipoAtivo;

	@Column(nullable = false)
	private String codigo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "moedaid", nullable = false)
	private Dominio moeda;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "segmentoid", nullable = false)
	private Segmento segmento;

	private String observacao;
	private Short nota = 0;

	private String cnpj;

	@Column(nullable = false)
	private String nome;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bancoid", nullable = false)
	private Banco banco;

	private BigDecimal precoMedio = BigDecimal.ZERO;
	private BigDecimal totalinvestido = BigDecimal.ZERO;
	private BigDecimal quantidadeinvestida = BigDecimal.ZERO;
	private BigDecimal valorAtual = BigDecimal.ZERO;
	private LocalDate dataatualizacao;
	private Boolean quarentena = false;

	public Ativo() {
		super();
	}

	public Ativo(GrupoUsuaria grupoUsuaria, TipoAtivo tipoAtivo, String codigo, Dominio moeda) {
		super();

		this.grupoUsuaria = grupoUsuaria;
		this.tipoAtivo = tipoAtivo;
		this.codigo = codigo;
		this.moeda = moeda;
	}

	public TipoAtivo getTipoAtivo() {
		return tipoAtivo;
	}

	public void setTipoAtivo(TipoAtivo tipoAtivo) {
		this.tipoAtivo = tipoAtivo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Dominio getMoeda() {
		return moeda;
	}

	public void setMoeda(Dominio moeda) {
		this.moeda = moeda;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Short getNota() {
		return nota;
	}

	public void setNota(Short nota) {
		this.nota = nota;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Boolean getQuarentena() {
		return quarentena;
	}

	public void setQuarentena(Boolean quarentena) {
		this.quarentena = quarentena;
	}

	public BigDecimal getTotalinvestido() {
		return totalinvestido;
	}

	public void setTotalinvestido(BigDecimal totalinvestido) {
		this.totalinvestido = totalinvestido;
	}

	public BigDecimal getQuantidadeinvestida() {
		return quantidadeinvestida;
	}

	public void setQuantidadeinvestida(BigDecimal quantidadeinvestida) {
		this.quantidadeinvestida = quantidadeinvestida;
	}

	public BigDecimal getValoratual() {
		return valorAtual;
	}

	public void setValoratual(BigDecimal valoratual) {
		this.valorAtual = valoratual;
	}

	public LocalDate getDataatualizacao() {
		return dataatualizacao;
	}

	public void setDataatualizacao(LocalDate dataatualizacao) {
		this.dataatualizacao = dataatualizacao;
	}

	public BigDecimal getPrecoMedio() {
		return precoMedio;
	}

	public void setPrecoMedio(BigDecimal precoMedio) {
		this.precoMedio = precoMedio;
	}

}
