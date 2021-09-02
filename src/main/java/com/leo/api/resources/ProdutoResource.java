package com.leo.api.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.api.models.Produto;
import com.leo.api.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtorepository;
	
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtorepository.findAll();
	}
	
	
	@GetMapping("/produtos/{id}")
	public Optional<Produto> buscaProduto(Long id){
		return produtorepository.findById(id);
	}
	
}
