package user11681.fantazorez;

import net.devtech.arrp.api.RRPCallback;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import user11681.fantazorez.block.FantaZBlocks;
import user11681.fantazorez.item.FantaZItems;
import user11681.fantazorez.resource.ReloadableRuntimeResources;
import user11681.usersmanual.world.gen.feature.ModTargets;

public class Main implements ModInitializer {
    public static final String MOD_ID = "fantazorez";
    public static final ReloadableRuntimeResources RESOURCES = ReloadableRuntimeResources.create(MOD_ID, "fantazorez");

    @Override
    public void onInitialize() {
        FantaZBlocks.register();
        FantaZItems.register();

        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((final int rawIdentifier, final Identifier identifier, final Biome biome) -> handleBiome(biome));

        RRPCallback.EVENT.register(RESOURCES::load);
    }

    private void handleBiome(final Biome biome) {
        final Biome.Category category = biome.getCategory();

        if (category == Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(ModTargets.END_STONE, FantaZBlocks.ANTEDILUVIAN_DEBRIS.getDefaultState(), 16))
                            .createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 0, 0, 255)))
            );
        } else if (category != Biome.Category.NETHER) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, FantaZBlocks.FANTAZIUM_ORE.getDefaultState(), 4))
                            .createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(2, 0, 0, 12)))
            );

            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, FantaZBlocks.PEARLIUM_ORE.getDefaultState(), 6))
                            .createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(6, 0, 0, 32)))
            );

            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, FantaZBlocks.IGNUM_ORE.getDefaultState(), 4))
                            .createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(4, 0, 0, 20)))
            );
        }
    }
}
