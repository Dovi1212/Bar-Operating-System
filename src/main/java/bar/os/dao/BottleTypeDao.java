package bar.os.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bar.os.entity.BottleType;

public interface BottleTypeDao extends JpaRepository<BottleType, Long> {

	Optional<BottleType> findByType(String type);

}
