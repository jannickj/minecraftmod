package mmm.esm.thirst.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mmm.esm.thirst.ItemDrink;
import mmm.esm.thirst.ThirstMod;

public class FilteredWaterCupItem extends ItemDrink {

	public FilteredWaterCupItem(int id) {
		super(id, 2, 50);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("filteredWaterCup");
	}
	
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:cupWater_filtered");
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		return new ItemStack(ThirstMod.woodenCup);
    }
}
