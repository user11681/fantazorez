package user11681.fantazorez.block;

import java.util.Random;
import net.minecraft.block.OreBlock;

public class AntediluvianDebrisBlock extends OreBlock {
    public AntediluvianDebrisBlock(final Settings settings) {
        super(settings);
    }

    @Override
    protected int getExperienceWhenMined(final Random random) {
        return 0;
    }
}
