package bar.os.controller.model;

import java.util.HashSet;
import java.util.Set;

import bar.os.entity.Cocktail;
import bar.os.entity.Tabs;
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
	
	private Set<Tabs> tabs = new HashSet<>();
	
	public CocktailData (Cocktail cocktail) {
		this.cocktailId = cocktail.getCocktailId();
		this.cocktailName = cocktail.getCocktailName();
		this.costToCustomer = cocktail.getCostToCustomer();
		this.instructions = cocktail.getInstructions();
		this.ingrediants = cocktail.getIngrediants();
		
		for(Tabs tab : cocktail.getTabs()) {
			this.tabs.add(new TabsData(tab));
		}		
		
	}
	public Cocktail toCocktail() {
		Cocktail cocktail = new Cocktail();
		cocktail.setCocktailId(cocktailId);
		cocktail.setCocktailName(cocktailName);
		cocktail.setCostToCustomer(costToCustomer);
		cocktail.setIngrediants(ingrediants);
		cocktail.setInstructions(instructions);
		
		for(TabsData tabsData : tabs) {
			cocktail.getTabs().add(tabsData.toTabs());
		}
		return cocktail;
	}
}
