package mmm.esm.thirst.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import mmm.esm.thirst.ItemDrink;

public class UnfilteredWaterCupItem extends ItemDrink {

	public UnfilteredWaterCupItem(int id, int thirstcount, int poisonticks) {
		super(id, thirstcount, poisonticks);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("unfilteredWaterCup");
	}
	
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:cupWater_unfiltered");
	}
}
