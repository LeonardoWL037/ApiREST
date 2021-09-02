package com.leo.api.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Produto buscaProduto(@PathVariable(value="id") long id){
		return produtorepository.findById(id);
	}
	
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtorepository.delete(produto);
	}
	
	
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
}
