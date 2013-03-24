package org.Barteks2x.b173gen.generator.beta173;

import java.util.Random;

import net.minecraft.server.v1_5_R1.Block;
import net.minecraft.server.v1_5_R1.Material;
import net.minecraft.server.v1_5_R1.World;
import org.Barteks2x.b173gen.generator.WorldGenerator173;

public class WorldGenCactus extends WorldGenerator173 {
	public WorldGenCactus() {
	}

	@Override
	public boolean a(World world, Random random, int i, int j, int k) {
		for (int l = 0; l < 10; l++) {
			int i1 = (i + random.nextInt(8)) - random.nextInt(8);
			int j1 = (j + random.nextInt(4)) - random.nextInt(4);
			int k1 = (k + random.nextInt(8)) - random.nextInt(8);
			if (!(world.getMaterial(i1, j1, k1) == Material.AIR)) {
				continue;
			}
			int l1 = 1 + random.nextInt(random.nextInt(3) + 1);
			for (int i2 = 0; i2 < l1; i2++) {
				if (canStay(world, i1, j1 + i2, k1)) {
					world.setTypeIdAndData(i1, j1 + i2, k1, Block.CACTUS.id, 0, 2);
				}
			}

		}

		return true;
	}

	public boolean canStay(World world, int i, int j, int k) {
		if (world.getMaterial(i - 1, j, k).isBuildable())
			return false;
		if (world.getMaterial(i + 1, j, k).isBuildable())
			return false;
		if (world.getMaterial(i, j, k - 1).isBuildable())
			return false;
		if (world.getMaterial(i, j, k + 1).isBuildable()) {
			return false;
		}
		int l = world.getTypeId(i, j - 1, k);

		return ((l == Block.CACTUS.id) || (l == Block.SAND.id));
	}
}
