package mmm.esm.thirst.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mmm.esm.thirst.ItemDrink;
import mmm.esm.thirst.ThirstMod;

public class UnfilteredWaterCupItem extends ItemDrink {

	public UnfilteredWaterCupItem(int id) {
		super(id, 2, 500);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("unfilteredWaterCup");
	}
	
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:cupWater_unfiltered");
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer); 
		par3EntityPlayer.getFoodStats().addStats(-14, 1);
		return new ItemStack(ThirstMod.woodenCup);
    }
}
