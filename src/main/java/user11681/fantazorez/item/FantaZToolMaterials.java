package user11681.fantazorez.item;

import java.util.function.Supplier;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum FantaZToolMaterials implements ToolMaterial {
    ENDERITE(5, 8192, 14, 5, 30, () -> Ingredient.ofItems(FantaZItems.ENDERITE_INGOT)),
    FANTAZIUM(4, 4096, 10, 4, 22, () -> Ingredient.ofItems(FantaZItems.FANTAZIUM_STAR)),
    IGNUM(3, 2048, 12, 5, 20, () -> Ingredient.ofItems(FantaZItems.IGNUM_GEM)),
    PEARLIUM(3, 1024, 7, 3, 18, () -> Ingredient.ofItems(FantaZItems.PEARLIUM));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    FantaZToolMaterials(final int miningLevel, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    public final int getDurability() {
        return this.itemDurability;
    }

    public final float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public final float getAttackDamage() {
        return this.attackDamage;
    }

    public final int getMiningLevel() {
        return this.miningLevel;
    }

    public final int getEnchantability() {
        return this.enchantability;
    }

    public final Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
