package br.edu.infnet.museuApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.museuApp.app.model.Obra;


public class ObraController {

	@Autowired
	private ObraService service;
	
	public ObraController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value = "/obra/listar", method = RequestMethod.GET)
	public String obraListar(Model model) {
		System.out.println("Entrei no obra list");
		List<Obra> obras = service.getObras();
		model.addAttribute("listaObras", obras);
		return "obra/listar";
	}
	
	@RequestMapping(value = "/obra/adicionarObra/{id}", method = RequestMethod.GET)
	public String adicionarObra(@PathVariable("id")String id, Model model) {
		System.out.println("Entrei no adicionar obra");
		List<Obra> obras = service.getObrasExtras();
		model.addAttribute("obras", obras);
		model.addAttribute("museuId", id);
		return "obra/adicionarObra";
	}
	
	@RequestMapping(value = "/obra/adcionar" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "obra/adicionar";
	}
	
	@RequestMapping(value = "/obra/add", method = RequestMethod.POST)
	public String save(Model model, Obra obra) {
		service.persite(obra);
		return "redirect:/obra/listar";
	}
	
	@RequestMapping(value = "/obra/editar/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		Obra obra = service.getObra(id);
		model.addAttribute("obra", obra);
		return "obra/editar";
	}
	
	@RequestMapping(value = "/obra/update", method = RequestMethod.POST)
	public String update(Model model, Obra obra) {
		service.update(obra);
		return "redirect:/obra/listar";
	}
	
	@RequestMapping(value = "/obra/deletar/{id}", method = RequestMethod.GET)
	public String deletar(@PathVariable("id") String id) {
		System.out.println("Entrei no obra delatar");
		service.delete(id);
		return "redirect:/obra/listar";
	}
	

	
	
}
