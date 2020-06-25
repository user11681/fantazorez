package user11681.fantazorez;

import net.minecraft.util.Identifier;

public class ModID {
    public static String namespaced(final String path) {
        return String.format("%s:%s", Main.MOD_ID, path);
    }

    public static Identifier identifier(final String path) {
        return new Identifier(Main.MOD_ID, path);
    }
}
