package bar.os.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;
	
	private String name;
	
	private Long cost;
	
	private Long sizeInOz;
	
	private Long inInventory;
	
	@Embedded
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name = "type", nullable = false)
	private BottleType bottleType;
	
	
}
