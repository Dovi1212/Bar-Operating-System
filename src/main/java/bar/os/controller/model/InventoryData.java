package bar.os.controller.model;

import bar.os.entity.BottleType;
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
	private BottleType bottleType = new BottleType();
	
	
	public InventoryData (Inventory inventory) {
		this.inventoryId = inventory.getInventoryId();
		this.name = inventory.getName();
		this.cost = inventory.getCost();
		this.sizeInOz = inventory.getSizeInOz();
		this.inInventory = inventory.getInInventory();
		this.bottleType = new BottleType();
		
	}
	
	
	@Data
	@NoArgsConstructor
	static class BottleTypeResponse {
		private Long bottleTypeId;
		private String name;
		
		BottleTypeResponse (BottleType bottleType) {
			bottleTypeId = bottleType.getBottleTypeId();
			name = bottleType.getName();
		}
		
	}


	public Inventory toInventory() {
		Inventory inventory = new Inventory();
		inventory.setInventoryId(inventoryId);
		inventory.setName(name);
		inventory.setCost(cost);
		inventory.setSizeInOz(sizeInOz);
		inventory.setInInventory(inInventory);
		inventory.setBottleType(bottleType);
		
		return inventory;
	}
	
}
