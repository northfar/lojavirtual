package com.lojavirtual.lojavirtual.repository;

import org.springframework.data.repository.CrudRepository;

import com.lojavirtual.lojavirtual.model.Produto;


public interface ProdutoRepository extends CrudRepository<Produto,String>{

	Produto findById(long id);
}
