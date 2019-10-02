package br.edu.infnet.museuApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.museuApp.app.model.Museu;
import br.edu.infnet.museuApp.app.model.Obra;


@Controller
public class MuseuController {
	
	@Autowired
	private MuseuService service;
	@Autowired
	private ObraService oService;
	@Autowired
	private MuseuObraService moService;
	
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
	
	// OBRA SERVICE
	
	@RequestMapping(value = "/obra/listar", method = RequestMethod.GET)
	public String obraListar(Model model) {
		System.out.println("Entrei no obra list");
		List<Obra> obras = oService.getObras();
		model.addAttribute("listaObras", obras);
		return "obra/listar";
	}
	
	@RequestMapping(value = "/obra/adicionarObra/{id}", method = RequestMethod.GET)
	public String adicionarObra(@PathVariable("id")String id, Model model) {
		System.out.println("Entrei no adicionar obra");
		List<Obra> obras = oService.getObrasExtras();
		model.addAttribute("obras", obras);
		model.addAttribute("museuId", id);
		return "obra/adicionarObra";
	}
	
	@RequestMapping(value = "/obra/adcionar" , method = RequestMethod.GET)
	public String viewForm1(Model model) {
		return "obra/adicionar";
	}
	
	@RequestMapping(value = "/obra/add", method = RequestMethod.POST)
	public String save(Model model, Obra obra) {
		oService.persite(obra);
		return "redirect:/obra/listar";
	}
	
	@RequestMapping(value = "/obra/editar/{id}", method = RequestMethod.GET)
	public String editO(@PathVariable("id") String id, Model model) {
		Obra obra = oService.getObra(id);
		model.addAttribute("obra", obra);
		return "obra/editar";
	}
	
	@RequestMapping(value = "/obra/update", method = RequestMethod.POST)
	public String update(Model model, Obra obra) {
		oService.update(obra);
		return "redirect:/obra/listar";
	}
	
	@RequestMapping(value = "/obra/deletar/{id}", method = RequestMethod.GET)
	public String deletarO(@PathVariable("id") String id) {
		System.out.println("Entrei no obra delatar");
		oService.delete(id);
		return "redirect:/obra/listar";
	}

	public ObraService getoService() {
		return oService;
	}

	public void setoService(ObraService oService) {
		this.oService = oService;
	}
	
	//     MUSEU OBRA SERVICE
	
	@RequestMapping(value = "/museu/adicionarObra", method = RequestMethod.GET)
	public String adicionarObra(@RequestParam("obraId")String obraId,@RequestParam("museuId")String museuId, Model model) {
		System.out.println("Entrei no adicionar obra");
		System.out.println(obraId);
		System.out.println(museuId);
		moService.updateAdd(obraId, museuId);
		return "redirect:/museu/acervo/"+museuId;
	}
	
	@RequestMapping(value = "/museu/removerObra", method = RequestMethod.GET)
	public String removerObra(@RequestParam("obraId")String obraId,@RequestParam("museuId")String museuId, Model model) {
		System.out.println("Entrei no remover obra");
		System.out.println(obraId);
		System.out.println(museuId);
		moService.updateRemove(obraId, museuId);
		return "redirect:/museu/acervo/"+museuId;
	}


	
}
