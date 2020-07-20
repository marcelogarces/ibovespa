package br.com.ibovespa.pregao.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibovespa.pregao.model.Ordem;

@Service
public class OrdemService {
	
	@Autowired
	private OrdemRepository ordemRepository;
	
	public void gravarOrdem(Ordem ordem)throws ConstraintViolationException{

			ordemRepository.save(ordem);	
	}
	
	
	public List<Ordem> findByOrdensByCpf(String cpf)throws Exception, RuntimeException{
		

		return ordemRepository.findAllByCpf(cpf);
	}

}
