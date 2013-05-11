package mmm.esm.thirst.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBarrel extends TileEntity {

	public static final String Name = "tileentityBarrel";
	private int waterlevel = 0;
	
	public int getWaterlevel() {
		// TODO Auto-generated method stub
		return waterlevel;
	}

	public void modWaterlevel(int i) {
		waterlevel+=i;		
	}
	
	public int getMaxWaterlevel()
	{
		return 40;
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
       
        this.waterlevel = par1NBTTagCompound.getInteger("barrel_waterlevel");
      
    }
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        
        par1NBTTagCompound.setInteger("barrel_waterlevel", this.waterlevel);
        
       

    }


}
