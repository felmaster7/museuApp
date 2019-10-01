package br.edu.infnet.museuApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.museuApp.app.model.Museu;
import br.edu.infnet.museuApp.app.model.Obra;
import br.edu.infnet.museuApp.app.model.Todo;

@Controller
public class MuseuController {
	
	@Autowired
	private MuseuService service;
	
	@RequestMapping(value = "/museu/listar", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("Entrei no museu list");
		List<Museu> museus = service.getMuseus();
		model.addAttribute("listaMuseus", museus);
		return "museu/listar";
	}
	
	@RequestMapping(value = "/museu/adcionar" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "museu/adicionar";
	}
	
	@RequestMapping(value = "/museu/add", method = RequestMethod.POST)
	public String save(Model model, Museu museu) {
		service.persite(museu);
		return "redirect:/museu/listar";
	}
	
	@RequestMapping(value = "/museu/editar/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		Museu museu = service.getMuseu(id);
		model.addAttribute("museu", museu);
		return "museu/editar";
	}
	
	@RequestMapping(value = "/museu/update", method = RequestMethod.POST)
	public String update(Model model, Museu museu) {
		service.update(museu);
		return "redirect:/museu/listar";
	}
	
	@RequestMapping(value = "/museu/deletar/{id}", method = RequestMethod.GET)
	public String deletar(@PathVariable("id") String id) {
		service.delete(id);
		return "redirect:/museu/listar";
	}
	
	@RequestMapping(value = "/museu/acervo/{id}", method = RequestMethod.GET)
	public String acervo(@PathVariable("id") String id, Model model) {
		System.out.println("Entrei acervo do museu");
		Museu museu = service.getMuseu(id);
		model.addAttribute("museu", museu);
		System.out.println(museu);
		System.out.println(museu.getAcervo());
		return "museu/acervo";
	}
	

	public MuseuService getService() {
		return service;
	}

	public void setService(MuseuService service) {
		this.service = service;
	}
	
}
