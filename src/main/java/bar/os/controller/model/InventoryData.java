package bar.os.controller.model;

import bar.os.entity.Inventory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryData {
	
	private Long inventoryId;
	private String name;
	private Long cost;
	private Long sizeInOz;
	private Long inInventory;
	
	
	public InventoryData (Inventory inventory) {
		this.inventoryId = inventory.getInventoryId();
		this.name = inventory.getName();
		this.cost = inventory.getCost();
		this.sizeInOz = inventory.getSizeInOz();
		this.inInventory = inventory.getInInventory();		
	}
	
	public Inventory toInventory() {
		Inventory inventory = new Inventory();
		
		inventory.setInventoryId(inventoryId);
		inventory.setName(name);
		inventory.setCost(cost);
		inventory.setSizeInOz(sizeInOz);
		inventory.setInInventory(inInventory);
		
		return inventory;
	}
}
