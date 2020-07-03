package br.com.ibovespa.pregao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibovespa.pregao.dto.CompraDTO;
import br.com.ibovespa.pregao.model.Ordem;
import br.com.ibovespa.pregao.model.StatusOrdem;
import br.com.ibovespa.pregao.model.TipoOrdem;
import br.com.ibovespa.pregao.service.OrdemService;

@RestController
@RequestMapping("/ordem")
public class OrdemController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrdemController.class);
	
	
	@Autowired
	private OrdemService ordemService;
	
	@RequestMapping("/ativo/compra")
	public void executarOrdemCompra(@RequestBody CompraDTO ordemCompraVenda) {
		
		LOG.info("Recebido ordem da corretora");
		
	
		Ordem ordem = new Ordem();
		
		ordem.setCodigoAtivo(ordemCompraVenda.getCodigoAtivo());		
		ordem.setPreco(ordemCompraVenda.getPreco());
		ordem.setQuantidade(ordemCompraVenda.getQuantidade());
		ordem.setTipoOrdem(TipoOrdem.COMPRA);
		ordem.setStatus(StatusOrdem.ABERTO);
		
		ordemService.gravarOrdem(ordem);
		
	}

	@RequestMapping("ativo/venda")
	public void executarOrdemVenda() {

		
	}
}
