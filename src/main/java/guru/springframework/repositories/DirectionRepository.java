package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Direction;
import guru.springframework.domain.Recipe;

public interface DirectionRepository extends CrudRepository<Direction, Long> {
	
	void deleteByRecipe(Recipe recipe);
}

