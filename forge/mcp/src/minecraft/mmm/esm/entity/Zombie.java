package mmm.esm.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Zombie extends EntityZombie
{
	@Override
	public int getMaxHealth()
	{
		return 100; 
	}
	
	@Override
	public int getAttackStrength(Entity par1Entity)
    {
        ItemStack itemstack = this.getHeldItem();
        float f = (float)(this.getMaxHealth() - this.getHealth()) / (float)this.getMaxHealth();
        int i = 9 + MathHelper.floor_float(f * 4.0F);

        if (itemstack != null)
        {
            i += itemstack.getDamageVsEntity(this);
        }

        return i;
    }
	
	public Zombie(World par1World) 
	{
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
