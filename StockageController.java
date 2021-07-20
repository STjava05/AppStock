package it.esedra.appstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.esedra.appstock.entity.Stockage;
import it.esedra.appstock.repository.StockageRepository;


@RestController
public class StockageController {

	@Autowired
	
	private StockageRepository stockageRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView stockage() {
		ModelAndView art = new ModelAndView();
		art.setViewName("stockage");
		List<Stockage> listStockage = stockageRepository.findAll();
		art.addObject("listStockage", listStockage);
		art.addObject("stockage", new Stockage());
		return art;
	}
	
	@GetMapping("/stockages")
	public Iterable<Stockage>getAllStockages(Model model){
		
		return stockageRepository.findAll();
	}
	
	@RequestMapping( value="/", method=RequestMethod.POST)
	public ModelAndView add(@Validated Stockage stockage, BindingResult bindingResult) {
    	ModelAndView art = new ModelAndView();
    	stockageRepository.save(stockage);
    	List<Stockage> listStockage = stockageRepository.findAll();
    	art.addObject("listStockage", listStockage);
		art.addObject("stockage", new Stockage());
    	
    	return art;
	}
}
