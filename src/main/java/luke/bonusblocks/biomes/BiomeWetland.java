package luke.bonusblocks.biomes;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.BiomeSwamp;

public class BiomeWetland extends BiomeSwamp {

    public BiomeWetland() {
        this.topBlock = (short) Block.blockClay.id;
        this.fillerBlock = (short) Block.blockClay.id;
    }

}
