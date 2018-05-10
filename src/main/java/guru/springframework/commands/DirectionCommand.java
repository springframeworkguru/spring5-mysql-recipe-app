package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sq on 4/14/18.
 */
@Setter
@Getter
@NoArgsConstructor
public class DirectionCommand {
    private Long id;
    private Long recipeId;
	private String description;
	private Integer order;
}
