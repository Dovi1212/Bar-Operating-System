package bar.os.controller.model;

import java.util.HashSet;
import java.util.Set;

import bar.os.entity.Cocktail;
import bar.os.entity.Tab;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CocktailData {

	private Long cocktailId;
	private String cocktailName;
	private Long costToCustomer;
	private String instructions;
	private String ingrediants;
	private BottleTypeData baseLiqour = new BottleTypeData();
	
	private Set<TabData> tabs = new HashSet<>();
	
	public CocktailData (Cocktail cocktail) {
		this.cocktailId = cocktail.getCocktailId();
		this.cocktailName = cocktail.getName();
		this.costToCustomer = cocktail.getCostToCustomer();
		this.instructions = cocktail.getInstructions();
		this.ingrediants = cocktail.getIngrediants();
		
		for(Tab tab : cocktail.getTabs()) {
			this.tabs.add(new TabData(tab));
		}		
		
	}

}
