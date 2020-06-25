package user11681.fantazorez.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import user11681.fantazorez.Main;

public class FantaZBlocks {
    public static final AntediluvianDebrisBlock ANTEDILUVIAN_DEBRIS = new AntediluvianDebrisBlock(breakByPickaxe(4, 40, 1600));
    public static final FantaziumOreBlock FANTAZIUM_ORE = new FantaziumOreBlock(breakByPickaxe(3, 50, 2000));
    public static final IgnumOreBlock IGNUM_ORE = new IgnumOreBlock(breakByPickaxe(2, 3, 5).lightLevel(15));
    public static final PearliumOreBlock PEARLIUM_ORE = new PearliumOreBlock(breakByPickaxe(2, 3, 5));

    private static FabricBlockSettings breakByPickaxe(final int miningLevel, final int hardness, final int resistance) {
        return FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness, resistance);
    }

    public static void register() {
        register(ANTEDILUVIAN_DEBRIS, "antediluvian_debris");
        register(FANTAZIUM_ORE, "fantazium_ore");
        register(IGNUM_ORE, "ignum_ore");
        register(PEARLIUM_ORE, "pearlium_ore");
    }

    private static void register(final Block block, final String name) {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, name), block);
    }
}
