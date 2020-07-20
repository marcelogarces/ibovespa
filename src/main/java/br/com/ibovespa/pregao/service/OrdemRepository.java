package br.com.ibovespa.pregao.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ibovespa.pregao.model.Ordem;

@Repository
public interface OrdemRepository extends CrudRepository<Ordem, Long> {
	
	
	@Query("SELECT o from Ordem o where o.cpf = :cpf")
	List<Ordem> findAllByCpf(String cpf)throws Exception;
	

	
}
