package br.com.ibovespa.pregao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigoAtivo;
	
	private Integer quantidade;
	
	private Double preco;
	
	@Enumerated(EnumType.STRING)
	private TipoOrdem tipoOrdem;
	
	@Enumerated(EnumType.STRING)
	private StatusOrdem status;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoAtivo() {
		return codigoAtivo;
	}

	public void setCodigoAtivo(String nomeAtivo) {
		this.codigoAtivo = nomeAtivo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoOrdem getTipoOrdem() {
		return tipoOrdem;
	}

	public void setTipoOrdem(TipoOrdem tipoOrdem) {
		this.tipoOrdem = tipoOrdem;
	}

	public StatusOrdem getStatus() {
		return status;
	}

	public void setStatus(StatusOrdem status) {
		this.status = status;
	}
}
