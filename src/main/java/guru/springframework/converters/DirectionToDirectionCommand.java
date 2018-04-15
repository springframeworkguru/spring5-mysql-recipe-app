package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.commands.DirectionCommand;
import guru.springframework.domain.Direction;
import lombok.Synchronized;

/**
 * Created by sq on 4/14/18.
 */
@Component
public class DirectionToDirectionCommand implements Converter<Direction, DirectionCommand> {

	@Synchronized
    @Nullable
    @Override
    public DirectionCommand convert(Direction direction) {
        if (direction == null) {
            return null;
        }

        DirectionCommand directionCommand = new DirectionCommand();
        directionCommand.setId(direction.getId());
        if (direction.getRecipe() != null) {
        	directionCommand.setRecipeId(direction.getRecipe().getId());
        }
        directionCommand.setOrder(direction.getOrder());
        directionCommand.setDescription(direction.getDescription());
        return directionCommand;
    }

}
