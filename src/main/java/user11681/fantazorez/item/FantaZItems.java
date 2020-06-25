package user11681.fantazorez.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import user11681.fantazorez.Main;
import user11681.fantazorez.block.FantaZBlocks;
import user11681.fantazorez.item.axe.EnderiteAxeItem;
import user11681.fantazorez.item.axe.FantaziumAxeItem;
import user11681.fantazorez.item.axe.IgnumAxeItem;
import user11681.fantazorez.item.axe.PearliumAxeItem;
import user11681.fantazorez.item.hoe.EnderiteHoeItem;
import user11681.fantazorez.item.hoe.FantaziumHoeItem;
import user11681.fantazorez.item.hoe.IgnumHoeItem;
import user11681.fantazorez.item.hoe.PearliumHoeItem;
import user11681.fantazorez.item.pickaxe.EnderitePickaxeItem;
import user11681.fantazorez.item.pickaxe.FantaziumPickaxeItem;
import user11681.fantazorez.item.pickaxe.IgnumPickaxeItem;
import user11681.fantazorez.item.pickaxe.PearliumPickaxeItem;
import user11681.fantazorez.item.shovel.EnderiteShovelItem;
import user11681.fantazorez.item.shovel.FantaziumShovelItem;
import user11681.fantazorez.item.shovel.IgnumShovelItem;
import user11681.fantazorez.item.shovel.PearliumShovelItem;
import user11681.fantazorez.item.sword.EnderiteSwordItem;
import user11681.fantazorez.item.sword.FantaziumSwordItem;
import user11681.fantazorez.item.sword.IgnumSwordItem;
import user11681.fantazorez.item.sword.PearliumSwordItem;


public class FantaZItems {
    public static final BlockItem ANTEDILUVIAN_DEBRIS = new BlockItem(FantaZBlocks.ANTEDILUVIAN_DEBRIS, blockItemSettings());
    public static final BlockItem FANTAZIUM_ORE = new BlockItem(FantaZBlocks.FANTAZIUM_ORE, blockItemSettings());
    public static final BlockItem PEARLIUM_ORE = new BlockItem(FantaZBlocks.PEARLIUM_ORE, blockItemSettings());
    public static final BlockItem IGNUM_ORE = new BlockItem(FantaZBlocks.IGNUM_ORE, blockItemSettings());

    public static final EnderiteIngotItem ENDERITE_INGOT = new EnderiteIngotItem(itemSettings());
    public static final EnderiteScrapItem ENDERITE_SCRAP = new EnderiteScrapItem(itemSettings());
    public static final FantaziumGemItem FANTAZIUM_STAR = new FantaziumGemItem(itemSettings());
    public static final IgnumGemItem IGNUM_GEM = new IgnumGemItem(itemSettings());
    public static final PearliumItem PEARLIUM = new PearliumItem(itemSettings());
    public static final StackedEnderiteScraps STACKED_ENDERITE_SCRAPS = new StackedEnderiteScraps(itemSettings());

    public static final EnderiteSwordItem ENDERITE_SWORD = new EnderiteSwordItem(FantaZToolMaterials.ENDERITE, 3, -2.4F, toolSettings());
    public static final FantaziumSwordItem FANTAZIUM_SWORD = new FantaziumSwordItem(FantaZToolMaterials.FANTAZIUM, 3, -2.4F, toolSettings());
    public static final IgnumSwordItem IGNUM_SWORD = new IgnumSwordItem(FantaZToolMaterials.IGNUM, 3, -2.4F, toolSettings());
    public static final PearliumSwordItem PEARLIUM_SWORD = new PearliumSwordItem(FantaZToolMaterials.PEARLIUM, 3, -2.4F, toolSettings());

    public static final EnderiteAxeItem ENDERITE_AXE = new EnderiteAxeItem(FantaZToolMaterials.ENDERITE, 5, -3.2F, toolSettings());
    public static final FantaziumAxeItem FANTAZIUM_AXE = new FantaziumAxeItem(FantaZToolMaterials.FANTAZIUM, 5, -3.2F, toolSettings());
    public static final IgnumAxeItem IGNUM_AXE = new IgnumAxeItem(FantaZToolMaterials.IGNUM, 5, -3.2F, toolSettings());
    public static final PearliumAxeItem PEARLIUM_AXE = new PearliumAxeItem(FantaZToolMaterials.PEARLIUM, 5, -3.2F, toolSettings());

    public static final EnderitePickaxeItem ENDERITE_PICKAXE = new EnderitePickaxeItem(FantaZToolMaterials.ENDERITE, 1, -2.8F, toolSettings());
    public static final FantaziumPickaxeItem FANTAZIUM_PICKAXE = new FantaziumPickaxeItem(FantaZToolMaterials.FANTAZIUM, 1, -2.8F, toolSettings());
    public static final IgnumPickaxeItem IGNUM_PICKAXE = new IgnumPickaxeItem(FantaZToolMaterials.IGNUM, 1, -2.8F, toolSettings());
    public static final PearliumPickaxeItem PEARLIUM_PICKAXE = new PearliumPickaxeItem(FantaZToolMaterials.PEARLIUM, 1, -2.8F, toolSettings());

    public static final EnderiteShovelItem ENDERITE_SHOVEL = new EnderiteShovelItem(FantaZToolMaterials.ENDERITE, 0, -3, toolSettings());
    public static final FantaziumShovelItem FANTAZIUM_SHOVEL = new FantaziumShovelItem(FantaZToolMaterials.FANTAZIUM, 0, -3, toolSettings());
    public static final IgnumShovelItem IGNUM_SHOVEL = new IgnumShovelItem(FantaZToolMaterials.IGNUM, 0, -3, toolSettings());
    public static final PearliumShovelItem PEARLIUM_SHOVEL = new PearliumShovelItem(FantaZToolMaterials.PEARLIUM, 0, -3, toolSettings());

    public static final EnderiteHoeItem ENDERITE_HOE = new EnderiteHoeItem(FantaZToolMaterials.ENDERITE, 0, 0, toolSettings());
    public static final FantaziumHoeItem FANTAZIUM_HOE = new FantaziumHoeItem(FantaZToolMaterials.FANTAZIUM, 0, 0, toolSettings());
    public static final IgnumHoeItem IGNUM_HOE = new IgnumHoeItem(FantaZToolMaterials.IGNUM, 0, 0, toolSettings());
    public static final PearliumHoeItem PEARLIUM_HOE = new PearliumHoeItem(FantaZToolMaterials.PEARLIUM, 0, 0, toolSettings());

    public static void register() {
        registerBlockItems(
                ANTEDILUVIAN_DEBRIS,
                FANTAZIUM_ORE,
                PEARLIUM_ORE,
                IGNUM_ORE
        );

        registerItem(ENDERITE_INGOT, "enderite_ingot");
        registerItem(ENDERITE_SCRAP, "enderite_scrap");
        registerItem(FANTAZIUM_STAR, "fantazium_star");
        registerItem(PEARLIUM, "pearlium");
        registerItem(IGNUM_GEM, "ignum_gem");
        registerItem(STACKED_ENDERITE_SCRAPS, "stacked_enderite_scrap");

        registerItem(ENDERITE_SWORD, "enderite_sword");
        registerItem(FANTAZIUM_SWORD, "fantazium_sword");
        registerItem(IGNUM_SWORD, "ignum_sword");
        registerItem(PEARLIUM_SWORD, "pearlium_sword");

        registerItem(ENDERITE_AXE, "enderite_axe");
        registerItem(FANTAZIUM_AXE, "fantazium_axe");
        registerItem(IGNUM_AXE, "ignum_axe");
        registerItem(PEARLIUM_AXE, "pearlium_axe");

        registerItem(ENDERITE_PICKAXE, "enderite_pickaxe");
        registerItem(FANTAZIUM_PICKAXE, "fantazium_pickaxe");
        registerItem(IGNUM_PICKAXE, "ignum_pickaxe");
        registerItem(PEARLIUM_PICKAXE, "pearlium_pickaxe");

        registerItem(ENDERITE_SHOVEL, "enderite_shovel");
        registerItem(FANTAZIUM_SHOVEL, "fantazium_shovel");
        registerItem(IGNUM_SHOVEL, "ignum_shovel");
        registerItem(PEARLIUM_SHOVEL, "pearlium_shovel");

        registerItem(ENDERITE_HOE, "enderite_hoe");
        registerItem(FANTAZIUM_HOE, "fantazium_hoe");
        registerItem(IGNUM_HOE, "ignum_hoe");
        registerItem(PEARLIUM_HOE, "pearlium_hoe");
    }

    private static Item.Settings toolSettings() {
        return new Item.Settings().group(ItemGroup.TOOLS);
    }

    private static Item.Settings blockItemSettings() {
        return new Item.Settings().group(ItemGroup.DECORATIONS);
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().group(ItemGroup.MISC);
    }

    private static void registerBlockItems(final BlockItem... items) {
        for (final BlockItem item : items) {
            Registry.register(Registry.ITEM, Registry.BLOCK.getId(item.getBlock()), item);
        }
    }

    private static void registerItem(final Item item, final String name) {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, name), item);
    }
}
