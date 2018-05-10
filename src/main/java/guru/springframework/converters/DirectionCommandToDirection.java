package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.commands.DirectionCommand;
import guru.springframework.domain.Direction;
import guru.springframework.domain.Recipe;

/**
 * Created by sq on 4/14/18.
 */
@Component
public class DirectionCommandToDirection implements Converter<DirectionCommand, Direction> {

	@Nullable
    @Override
    public Direction convert(DirectionCommand source) {
        if (source == null) {
            return null;
        }

        final Direction direction = new Direction();
        direction.setId(source.getId());

        if(source.getRecipeId() != null){
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            direction.setRecipe(recipe);
            recipe.addDirection(direction);
        }

        direction.setOrder(source.getOrder());
        direction.setDescription(source.getDescription());
        return direction;
    }
}
