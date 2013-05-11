package mmm.esm.entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.World;

public class Spider extends EntitySpider{

	public Spider(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

	@Override
	 public float spiderScaleAmount()
    {
        return 1.8F;
    }
	
	@Override
	 public int getMaxHealth()
    {
        return 60;
    }
	
	@Override
	protected Entity findPlayerToAttack()
    {
        float f = this.getBrightness(1.0F);

        if (f > 0.0F)
        {
            double d0 = 16.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        }
        else
       {
            return null;
        }
    }

	
}
