package bar.os.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bar.os.entity.BottleType;
import bar.os.entity.Inventory;

public interface BottleTypeDao extends JpaRepository<BottleType, Long> {


	BottleType findByName(String name);

	BottleType findByInventoryName(String inventoryName);

	BottleType findByCocktailName(String cocktailName);
}
