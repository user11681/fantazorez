package user11681.fantazorez.resource.client;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import user11681.fantazorez.ModID;
import user11681.fantazorez.resource.ResourceManager;

@Environment(EnvType.CLIENT)
public class ClientResourceManager extends ResourceManager {
    protected static final String[] TOOLS = {
            "sword", "axe", "pickaxe", "shovel", "hoe"
    };

    public ClientResourceManager(final RuntimeResourcePack resources) {
        super(resources);
    }

    protected static String slash(final String prefix, final String suffix) {
        return join(prefix, "/", suffix);
    }

    protected static String underscore(final String prefix, final String suffix) {
        return join(prefix, "_", suffix);
    }

    protected static String join(final String prefix, final String middle, final String suffix) {
        return String.format("%s%s%s", prefix, middle, suffix);
    }

    @Override
    public void load() {
        super.load();

        addBlocksWithItems("fantazium_ore", "ignum_ore", "pearlium_ore");
        addSidedBlocksWithItems("antediluvian_debris");
        addGenerated("enderite_ingot", "fantazium_star", "ignum_gem", "pearlium");
        addTools("enderite", "fantazium", "ignum", "pearlium");
    }

    protected void addBlocksWithItems(final String... names) {
        this.addBlocks(names);
        this.addBlockItems(names);
    }

    protected void addSidedBlocksWithItems(final String... names) {
        this.addSidedBlocks(names);
        this.addBlockItems(names);
    }

    protected void addSidedBlocks(final String... names) {
        for (final String path : names) {
            final String prefixedPath = slash("block", path);
            final String identifier = ModID.namespaced(prefixedPath);

            this.resources.addModel(
                    JModel.model("block/cube_column")
                            .textures(JModel.textures()
                                    .var("side", underscore(identifier, "side"))
                                    .var("end", underscore(identifier, "end"))
                            ),
                    ModID.identifier(prefixedPath)
            );

            this.resources.addBlockState(
                    JState.state(
                            JState.variant(
                                    JState.model(identifier)
                            )
                    ),
                    ModID.identifier(path)
            );
        }
    }

    protected void addBlocks(final String... materials) {
        for (final String material : materials) {
            final String prefixedPath = slash("block", material);

            this.resources.addModel(
                    JModel.model("block/cube_all")
                            .textures(JModel.textures()
                                    .var("all", ModID.namespaced(prefixedPath))
                            ),
                    ModID.identifier(prefixedPath)
            );

            this.resources.addBlockState(
                    JState.state(
                            JState.variant(
                                    JState.model(ModID.namespaced(prefixedPath))
                            )
                    ),
                    ModID.identifier(material)
            );
        }
    }

    protected void addBlockItems(final String... materials) {
        for (final String material : materials) {
            this.resources.addModel(
                    JModel.model(
                            ModID.namespaced(slash("block", material))
                    ),
                    ModID.identifier(slash("item", material))
            );
        }
    }

    protected void addTools(final String... materials) {
        for (final String material : materials) {
            for (final String tool : TOOLS) {
                addHandheld(underscore(material, tool));
            }
        }
    }

    protected void addHandheld(final String... names) {
        addItems("handheld", names);
    }

    protected void addGenerated(final String... names) {
        addItems("generated", names);
    }

    protected void addItems(final String parent, final String... names) {
        for (final String name : names) {
            final String prefixedPath = slash("item", name);

            this.resources.addModel(
                    JModel.model(slash("item", parent))
                            .textures(JModel.textures()
                                    .layer0(ModID.namespaced(prefixedPath))),
                    ModID.identifier(prefixedPath)
            );
        }
    }
}
