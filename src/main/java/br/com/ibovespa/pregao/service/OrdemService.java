package br.com.ibovespa.pregao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibovespa.pregao.model.Ordem;

@Service
public class OrdemService {
	
	@Autowired
	private OrdemRepository ordemRepository;
	
	public void gravarOrdem(Ordem ordem) {
				
		ordemRepository.save(ordem);
		
	}

}
