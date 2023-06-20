package bar.os.entity;

import java.util.HashSet;
import java.util.Set;

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
	
	private String cocktailName;
	
	private Long costToCustomer;
	
	private String instructions;
	
	private String ingrediants;
	
	@Embedded
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name = "type", nullable = false)
	private BottleType baseLiqour;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany
	@JoinTable(
			name = "tabs_cocktails",
			joinColumns = @JoinColumn (name = "tab_id"),
			inverseJoinColumns = @JoinColumn(name = "cocktail_id")	
			)
	private Set<Tabs> tabs = new HashSet<>();
	
}
