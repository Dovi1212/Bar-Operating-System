package bar.os.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bar.os.controller.model.CocktailData;
import bar.os.controller.model.CocktailData.CocktailBottleType;
import bar.os.entity.Cocktail;

public interface CocktailDao extends JpaRepository<Cocktail, Long> {

	Optional<Cocktail> findOpCocktailByName(String cocktailName);

	Long findCocktailIdByName(String name);






}
