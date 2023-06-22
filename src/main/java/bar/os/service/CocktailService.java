package bar.os.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bar.os.controller.model.CocktailData;
import bar.os.controller.model.InventoryData;
import bar.os.dao.CocktailDao;
import bar.os.dao.InventoryDao;
import bar.os.entity.Cocktail;


@Service
public class CocktailService {
	
	@Autowired
	private CocktailDao cocktailDao;

	@Transactional(readOnly = false)
	public CocktailData saveCocktail(CocktailData cocktailData) {
		Long cocktailId = cocktailData.getCocktailId();
		Cocktail cocktail = findOrCreateCocktail(cocktailId, cocktailData.getCocktailName());
		setFieldsInCocktail(cocktail, cocktailData);
		
		
		return new CocktailData(cocktailDao.save(cocktail));
	}

	private void setFieldsInCocktail(Cocktail cocktail, CocktailData cocktailData) {
		cocktail.setCocktailName(cocktailData.getCocktailName());
		cocktail.setCostToCustomer(cocktailData.getCostToCustomer());
		cocktail.setIngrediants(cocktailData.getIngrediants());
		cocktail.setInstructions(cocktailData.getInstructions());
		cocktail.setBaseLiqour(cocktailData.getBaseLiqour);
	}

	private Cocktail findOrCreateCocktail(Long cocktailId, String cocktailName) {
		Cocktail cocktail;
		
		if(Objects.isNull(cocktailId)) {
			Optional<Cocktail> opCocktail = cocktailDao.findOpCocktailByName(cocktailName);
			if (opCocktail.isPresent()) {
				throw new DuplicateKeyException("cocktail with name " + cocktailName + " already exists");
			}
			cocktail = new Cocktail();
		} else {
			cocktail = findCocktailByName(cocktailName);
		}
		
		return cocktail;
	}

	private Cocktail findCocktailByName(String cocktailName) {
		return cocktailDao.findOpCocktailByName(cocktailName).orElseThrow(() -> new NoSuchElementException("Inventory item with the name " + cocktailName + "doesnt exist"));
	}

	public Long getCocktailIdByName(String name) {
		Long response = findCocktailByName(name).getCocktailId();
		return response;
	}

	@Transactional(readOnly = true)
	public CocktailData retriveCocktailByName(String name) {
		Cocktail cocktail = findCocktailByName(name);
		return new CocktailData(cocktail);
	}

	@Transactional(readOnly = true)
	public List<CocktailData> retrieveAllCocktails() {
		List<Cocktail> cocktails = cocktailDao.findAll();
		List<CocktailData> response = new LinkedList<>();
		
		for(Cocktail cocktail : cocktails) {
			response.add(new CocktailData(cocktail));
		}
		return response;
	}
	
	@Transactional(readOnly = false)
	public void deleteByName(String name) {
		Cocktail cocktail = findCocktailByName(name);		
		
		cocktailDao.delete(cocktail);
	}
	
	@Transactional(readOnly = true)
	public List<CocktailData> retrieveAllCocktailsByType(String type) {
			List<Cocktail> cocktails =cocktailDao.findAllByType(type);
			List<CocktailData> response = new LinkedList<>();
			
			for(Cocktail cocktail : cocktails) {
				response.add(new CocktailData(cocktail));
			}
			
		return response;
	}

}
