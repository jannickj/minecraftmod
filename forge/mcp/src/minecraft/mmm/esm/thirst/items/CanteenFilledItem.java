package mmm.esm.thirst.items;

import mmm.esm.thirst.ItemDrink;
import mmm.esm.thirst.ThirstMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CanteenFilledItem extends ItemDrink {

	public CanteenFilledItem(int id) {
		super(id, 2, 0);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("CanteenFilled");
		this.setMaxDamage(getMaxUses());
	}
	
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:canteen_filled");
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		ItemStack s = par1ItemStack;
		s.damageItem(1, par3EntityPlayer);
	
		if(s.getItemDamage() == getMaxUses())
		{
			s = new ItemStack(ThirstMod.canteenUnfilled);
		}
		return s;
    }
	
	public int getMaxUses()
	{
		return 5;
	}
}