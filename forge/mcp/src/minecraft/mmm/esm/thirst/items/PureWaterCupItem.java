package mmm.esm.thirst.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mmm.esm.thirst.ItemDrink;
import mmm.esm.thirst.ThirstLoader;

public class PureWaterCupItem extends ItemDrink {

	public PureWaterCupItem(int id) {
		super(id, 4, 0);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("PureWaterCup");
	}
	
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:cupWater_pure");
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		return new ItemStack(ThirstLoader.woodenCup);
    }
}
