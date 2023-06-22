package bar.os.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bar.os.controller.model.CocktailData;
import bar.os.service.CocktailService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cocktail")
@Slf4j
public class CocktailController {
	
	@Autowired
	private CocktailService cocktailService;
	
	@PostMapping("/{employeeId}/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CocktailData addCocktail(@PathVariable Long employeeId, @RequestBody CocktailData cocktailData) {

		log.info("Adding {} to cocktail list.", cocktailData);
		return cocktailService.saveCocktail(cocktailData);
	}
	
	@PutMapping("/{employeeId}/update/{name}")
	public CocktailData updateCocktailByName(@PathVariable Long employeeId, @PathVariable String name,
			@RequestBody CocktailData cocktailData) {
		cocktailData.setCocktailId(cocktailService.getCocktailIdByName(name));
		log.info("Updating inventory item {} to {}. ", name, cocktailData);
		return cocktailService.saveCocktail(cocktailData);

	}
	
	@GetMapping("/get/{name}")
	public CocktailData retrieveCocktailByName(@PathVariable String name) {
		log.info("Retrieving cocktail {}.", name);
		return cocktailService.retriveCocktailByName(name);
	}
	
	@GetMapping("/get")
	public List<CocktailData> retrieveAllCocktails() {
		log.info("Retrieve all inventory called.");
		return cocktailService.retrieveAllCocktails();
		
	}
	
	@GetMapping("/get/{type}")
	public List<CocktailData> retrieveAllCocktailsByType(@PathVariable String type) {
		log.info("Retrieve all cocktails using {}.", type);
		return cocktailService.retrieveAllCocktailsByType(type);
		
	}
	
	@DeleteMapping("/{employeeId}/delete/{name}")
	public Map<String, String> deleteCocktailByName(@PathVariable Long employeeId, @PathVariable String name) {
		log.info("Deleting {} from cocktail list.", name);
		cocktailService.deleteByName(name);
		return Map.of("Message", "Deletion of " + name + " from cocktail list was successful.");
	}

	
	
}
