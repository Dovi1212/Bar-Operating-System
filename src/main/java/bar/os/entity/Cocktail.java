package bar.os.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	@ManyToOne
	@JoinColumn(name = "bottle_type_id")
	BottleType baseLiqour;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy = "cocktails", cascade = CascadeType.PERSIST)
	private Set<Tab> tabs = new HashSet<>();
	
}
