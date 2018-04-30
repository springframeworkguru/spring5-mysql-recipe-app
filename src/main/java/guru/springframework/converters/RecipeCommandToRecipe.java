package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

	private final CategoryCommandToCategory categoryConveter;
	private final IngredientCommandToIngredient ingredientConverter;
	private final NotesCommandToNotes notesConverter;
	private final DirectionCommandToDirection directionConverter;

	public RecipeCommandToRecipe(CategoryCommandToCategory categoryConveter,
			IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter,
			DirectionCommandToDirection directionConverter) {
		this.categoryConveter = categoryConveter;
		this.ingredientConverter = ingredientConverter;
		this.notesConverter = notesConverter;
		this.directionConverter = directionConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {
		if (source == null) {
			return null;
		}

		final Recipe recipe = new Recipe();
		recipe.setId(source.getId());
		recipe.setCookTime(source.getCookTime());
		recipe.setPrepTime(source.getPrepTime());
		recipe.setDescription(source.getDescription());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setServings(source.getServings());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());
		recipe.setNotes(notesConverter.convert(source.getNotes()));

		if (!CollectionUtils.isEmpty(source.getCategories())) {
			source.getCategories().forEach(category -> 
				recipe.getCategories().add(categoryConveter.convert(category)));
		}

		if (!CollectionUtils.isEmpty(source.getIngredients())) {
			source.getIngredients().forEach(ingredient -> {
				ingredient.setRecipeId(recipe.getId());
				recipe.getIngredients().add(ingredientConverter.convert(ingredient));
			});
		}

		if (!CollectionUtils.isEmpty(source.getDirections())) {
			source.getDirections().forEach(direction -> {
				direction.setRecipeId(recipe.getId());
				recipe.getDirections().add(directionConverter.convert(direction));
			});

		}

		return recipe;
	}
}
