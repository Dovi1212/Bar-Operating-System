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
	private InventoryBottleType bottleType;
	
	
	public InventoryData (Inventory inventory) {
		inventoryId = inventory.getInventoryId();
		name = inventory.getName();
		cost = inventory.getCost();
		sizeInOz = inventory.getSizeInOz();
		inInventory = inventory.getInInventory();
		bottleType = new InventoryBottleType(inventory.getBottleType());

		
	}
	
	@Data
	@NoArgsConstructor
	public static class InventoryBottleType {
		private Long bottleTypeId;
		private String name;
		
		public InventoryBottleType(BottleType bottleType) {
			bottleTypeId = bottleType.getBottleTypeId();
			name = bottleType.getName();
			
		}
	}
	

		
	}



	

