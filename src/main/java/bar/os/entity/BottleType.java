package bar.os.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

// Author: David Atwood 
//
//

@Data
@Entity
@Embeddable
public class BottleType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bottleTypeId;
	
	@EqualsAndHashCode.Exclude
	@Column(unique = true)
	private String type;
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "bottle_type", cascade = CascadeType.PERSIST)
	private Set<Cocktail> cocktails = new HashSet<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "bottle_type", cascade = CascadeType.PERSIST)
	private Set<Inventory> inventory = new HashSet<>();
	
	
}