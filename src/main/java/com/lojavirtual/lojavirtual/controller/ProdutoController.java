package com.lojavirtual.lojavirtual.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lojavirtual.lojavirtual.model.Produto;
import com.lojavirtual.lojavirtual.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoRepository pr;
	
	boolean flag = false;
	
	@RequestMapping("/produtos")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("produto/listaProdutos");
		Iterable<Produto> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping(value="/cadastrarproduto", method=RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("produto", new Produto());
	    flag = false;
		return "produto/formProduto";
	}
	
	@RequestMapping(value="produto", method=RequestMethod.POST)
	public String save(Produto produto){
		pr.save(produto);
		return "redirect:/produtos";
	}
	
	@RequestMapping(value="/editarproduto/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") long id,Model model){
		
		Produto prod = pr.findById(id);
		model.addAttribute("produto",prod);
		flag = true;
		return "produto/formProduto";
	}
	
	@RequestMapping("/deletarproduto/{id}")
	public String delete(@PathVariable long id){
		Produto produto = pr.findById(id);
		pr.delete(produto);
		return "redirect:/produtos";
	}
}
