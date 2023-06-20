package bar.os.controller.model;

import java.util.HashSet;
import java.util.Set;

import bar.os.entity.BottleType;
import bar.os.entity.Cocktail;
import bar.os.entity.Inventory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BottleTypeData {

	private Long bottleTypeId;
	private String type;
	
	private Set<CocktailData> cocktails = new HashSet<>();
	private Set<InventoryData> inventory = new HashSet<>();
	
	public BottleTypeData (BottleType bottleType) {
		this.bottleTypeId = bottleType.getBottleTypeId();
		this.type = bottleType.getType();
		
		for(Cocktail cocktail : bottleType.getCocktails()) {
			this.cocktails.add(new CocktailData(cocktail));
		}
		
		for (Inventory inventory : bottleType.getInventory()) {
			this.inventory.add(new InventoryData(inventory));
		}
	}
	
	public BottleTypeData (Long bottleTypeId, String type) {
		this.bottleTypeId = bottleTypeId;
		this.type = type;
	}
	
	public BottleType toBottleType() {
		
		BottleType bottleType = new BottleType();
		
		bottleType.setBottleTypeId(bottleTypeId);
		bottleType.setType(type);
		
		for (CocktailData cocktailData : cocktails) {
			bottleType.getCocktails().add(cocktailData.toCocktail());
		}
		
		for (InventoryData inventoryData : inventory) {
			bottleType.getInventory().add(inventoryData.toInventory());
		}
		return bottleType;
	}
}
