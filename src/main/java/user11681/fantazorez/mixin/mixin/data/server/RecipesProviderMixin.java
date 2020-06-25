package user11681.fantazorez.mixin.mixin.data.server;

import java.util.function.Consumer;
import net.minecraft.data.server.RecipesProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import user11681.fantazorez.event.GenerateRecipesCallback;

@Mixin(RecipesProvider.class)
public abstract class RecipesProviderMixin {
    @Inject(method = "generate", at = @At("RETURN"))
    private static void generate(final Consumer<RecipeJsonProvider> consumer, final CallbackInfo info) {
        GenerateRecipesCallback.EVENT.invoker().accept(consumer);
    }
}
