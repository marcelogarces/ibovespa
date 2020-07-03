package br.com.ibovespa.pregao.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ibovespa.pregao.model.Ordem;

@Repository
public interface OrdemRepository extends CrudRepository<Ordem, Long> {

}
