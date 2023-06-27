package bar.os.entity;

import jakarta.persistence.CascadeType;
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
public class Cocktail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cocktailId;
	
	private String name;
	
	private Long costToCustomer;
	
	private String instructions;
	
	private String ingrediants;
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "bottle_type_id", nullable = false)
	BottleType baseLiqour;		
}
