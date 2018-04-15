package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by sq on 4/14/18.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = { "recipe" })
@Entity
public class Direction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer order;

    @ManyToOne
    private Recipe recipe;

	public Direction() {
	}

	public Direction(String description, Integer order) {
		this.description = description;
		this.order = order;
	}

	public Direction(String description, Integer order, Recipe recipe) {
		this.description = description;
		this.order = order;
		this.recipe = recipe;
	}

}
