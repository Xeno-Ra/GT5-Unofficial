package gtPlusPlus.xmod.bop.blocks.rainforest;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.xmod.bop.blocks.BOPBlockRegistrator;
import gtPlusPlus.xmod.bop.blocks.base.SaplingBase;
import gtPlusPlus.xmod.bop.world.features.trees.WorldGenRainForestTree_Ex;

public class SaplingRainforestTree extends SaplingBase {

    public SaplingRainforestTree() {
        super("Rainforest Oak Sapling", "rainforestoak", new String[] { "rainforest" });
    }

    @Override
    public void func_149878_d(World world, int x, int y, int z, Random rand) {
        Logger.WARNING("func_149878_d - 1");
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        rand.nextInt(10);
        new WorldGenBigTree(true);
        new WorldGenTrees(true);
        int i1 = 0;
        int j1 = 0;

        Block block = Blocks.air;

        world.setBlock(x, y, z, block, 0, 4);
        WorldGenerator worldGenRainForestTreeEx = new WorldGenRainForestTree_Ex(
            BOPBlockRegistrator.log_Rainforest,
            BOPBlockRegistrator.leaves_Rainforest,
            0,
            0,
            true,
            50,
            75);

        if (!worldGenRainForestTreeEx.generate(world, rand, x + i1, y, z + j1)) {
            world.setBlock(x, y, z, this, l, 4);
        }
    }
}
