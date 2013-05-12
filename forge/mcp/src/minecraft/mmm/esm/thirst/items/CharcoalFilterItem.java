package mmm.esm.thirst.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mmm.esm.thirst.ItemDrink;
import mmm.esm.thirst.ThirstMod;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;

public class CharcoalFilterItem extends Item {

	public CharcoalFilterItem(int id) {
		super(id);
		
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("CharcoalFilter");
	}
	
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:charcoal_filter");
	}
	
}