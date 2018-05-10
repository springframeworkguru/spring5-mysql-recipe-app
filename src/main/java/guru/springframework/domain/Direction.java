package guru.springframework.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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
	
	@Lob
	private String description;
	
	@Column(name = "ordr")
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
