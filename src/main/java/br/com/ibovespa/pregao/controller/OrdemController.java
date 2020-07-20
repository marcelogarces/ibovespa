package br.com.ibovespa.pregao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ibovespa.pregao.dto.OrdemDTO;
import br.com.ibovespa.pregao.model.Ordem;
import br.com.ibovespa.pregao.model.StatusOrdem;
import br.com.ibovespa.pregao.model.TipoOrdem;
import br.com.ibovespa.pregao.service.OrdemService;

@RestController
public class OrdemController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrdemController.class);
	
	
	@Autowired
	private OrdemService ordemService;
	
	@RequestMapping("/ordem/ativo/compra")
	public ResponseEntity<Ordem> executarOrdemCompra(@RequestBody OrdemDTO ordemCompraVenda) {
		
		LOG.info("Recebido ordem da corretora");
		
		
		try {
			Ordem ordem = new Ordem();
			
			ordem.setCodigoAtivo(ordemCompraVenda.getCodigoAtivo());		
			ordem.setPreco(ordemCompraVenda.getPreco());
			ordem.setQuantidade(ordemCompraVenda.getQuantidade());
			ordem.setTipoOrdem(TipoOrdem.COMPRA);
			ordem.setStatus(StatusOrdem.ABERTO);
			ordem.setCpf(ordemCompraVenda.getCpf());
			ordem.setNomeCorretora(ordemCompraVenda.getNomeCorretora());
			
			ordemService.gravarOrdem(ordem);
			
			return ResponseEntity.ok().body(ordem);
			
		}catch (Exception e) {
			LOG.error("Erro ibov: ",e);
			
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping("ativo/venda")
	public void executarOrdemVenda() {

		
	}
	
	
	@RequestMapping("ordens/{cpf}")
	@ResponseBody
	public List<Ordem> consultarOrdensPorCPF(@PathVariable String cpf) {
		
		try {
			
			List<Ordem> ordens = ordemService.findByOrdensByCpf(cpf);
			
			return ordens;
			
			
		}catch (RuntimeException e) {
		LOG.error("Erro ibov operação consultarOrdensPorCPF:  ",e);
			
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, "Erro:", e);
			
		}catch (Exception e) {
			LOG.error("Erro ibov operação consultarOrdensPorCPF:  ",e);
			
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, "Erro:", e);
			
		}
	

		
	}
}
