package mmm.esm.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Skeleton extends EntitySkeleton
{
	public Skeleton(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getMaxHealth ()
	{
		return 100;
	}

	
}
