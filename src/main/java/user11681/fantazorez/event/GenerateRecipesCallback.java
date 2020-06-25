package user11681.fantazorez.event;

import java.util.function.Consumer;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

public interface GenerateRecipesCallback {
    Event<GenerateRecipesCallback> EVENT = EventFactory.createArrayBacked(GenerateRecipesCallback.class,
            (final GenerateRecipesCallback[] handlers) -> (final Consumer<RecipeJsonProvider> consumer) -> {
                for (final GenerateRecipesCallback handler : handlers) {
                    handler.accept(consumer);
                }
            }
    );

    void accept(Consumer<RecipeJsonProvider> consumer);
}
