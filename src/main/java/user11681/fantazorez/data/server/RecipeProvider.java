package user11681.fantazorez.data.server;

import java.util.function.Consumer;
import net.minecraft.advancement.criterion.EnterBlockCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.SmithingRecipeJsonFactory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.Tag;
import net.minecraft.util.registry.Registry;
import user11681.fantazorez.item.FantaZItems;

public class RecipeProvider {
    private static Consumer<RecipeJsonProvider> consumer;

    public static void generate(final Consumer<RecipeJsonProvider> providerConsumer) {
        consumer = providerConsumer;

        enderiteTool(Items.NETHERITE_PICKAXE, FantaZItems.ENDERITE_PICKAXE);
    }

    public static void enderiteTool(final Item left, final Item result) {
        smithing(left, FantaZItems.ENDERITE_INGOT, result).criterion("has_enderite_ingot", conditionsFromItem(FantaZItems.ENDERITE_INGOT)).offerTo(consumer, Registry.ITEM.getId(result.asItem()).getPath() + "_smithing");
    }

    public static SmithingRecipeJsonFactory smithing(final Item left, final Item right, final Item result) {
        return SmithingRecipeJsonFactory.create(Ingredient.ofItems(left), Ingredient.ofItems(right), result);
    }

    public static EnterBlockCriterion.Conditions requireEnteringFluid(Block block) {
        return new EnterBlockCriterion.Conditions(EntityPredicate.Extended.EMPTY, block, StatePredicate.ANY);
    }

    public static InventoryChangedCriterion.Conditions conditionsFromItem(ItemConvertible itemConvertible) {
        return conditionsFromItemPredicates(ItemPredicate.Builder.create().item(itemConvertible).build());
    }

    public static InventoryChangedCriterion.Conditions conditionsFromTag(Tag<Item> tag) {
        return conditionsFromItemPredicates(ItemPredicate.Builder.create().tag(tag).build());
    }

    public static InventoryChangedCriterion.Conditions conditionsFromItemPredicates(ItemPredicate... itemPredicates) {
        return new InventoryChangedCriterion.Conditions(EntityPredicate.Extended.EMPTY, NumberRange.IntRange.ANY, NumberRange.IntRange.ANY, NumberRange.IntRange.ANY, itemPredicates);
    }
}
