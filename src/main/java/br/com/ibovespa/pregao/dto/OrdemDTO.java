package br.com.ibovespa.pregao.dto;


public class OrdemDTO  {
	
	private String codigoAtivo;
	private Integer quantidade;
	private Double preco;
	private String nomeCorretora;
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCorretora() {
		return nomeCorretora;
	}
	public void setNomeCorretora(String nomeCorretora) {
		this.nomeCorretora = nomeCorretora;
	}
	
	
	public String getCodigoAtivo() {
		return codigoAtivo;
	}
	public void setCodigoAtivo(String codigoAtivo) {
		this.codigoAtivo = codigoAtivo;
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
	

}
