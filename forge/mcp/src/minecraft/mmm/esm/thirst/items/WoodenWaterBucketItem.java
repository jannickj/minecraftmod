package mmm.esm.thirst.items;

import mmm.esm.thirst.ItemDrink;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class WoodenWaterBucketItem extends ItemDrink {

	public WoodenWaterBucketItem(int par1) {
		super(par1, 10);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("woodenWaterBucket");
		
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
		
	         this.itemIcon = iconRegister.registerIcon("ThirstMod:WoodenWaterBucket");
	}

}
