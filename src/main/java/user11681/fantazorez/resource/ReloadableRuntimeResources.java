package user11681.fantazorez.resource;

import java.util.List;
import net.devtech.arrp.impl.RuntimeResourcePackImpl;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resource.ResourcePack;
import net.minecraft.util.Identifier;
import user11681.fantazorez.resource.client.ClientResourceManager;

public class ReloadableRuntimeResources extends RuntimeResourcePackImpl {
    @SuppressWarnings("NewExpressionSideOnly")
    protected final ResourceManager resourceManager =
            FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT
            ? new ClientResourceManager(this)
            : new ResourceManager(this);

    public ReloadableRuntimeResources(final Identifier id) {
        super(id);
    }

    public ReloadableRuntimeResources(final Identifier id, final int version) {
        super(id, version);
    }

    public static ReloadableRuntimeResources create(final String identifier) {
        return new ReloadableRuntimeResources(new Identifier(identifier));
    }

    public static ReloadableRuntimeResources create(final String identifier, final int version) {
        return new ReloadableRuntimeResources(new Identifier(identifier), version);
    }

    public static ReloadableRuntimeResources create(final String namespace, final String path) {
        return new ReloadableRuntimeResources(new Identifier(namespace, path));
    }

    public static ReloadableRuntimeResources create(final String namespace, final String path, final int version) {
        return new ReloadableRuntimeResources(new Identifier(namespace, path), version);
    }

    public void load(final List<ResourcePack> resourcePacks) {
        this.resourceManager.load();

        resourcePacks.add(1, this);
    }
}
