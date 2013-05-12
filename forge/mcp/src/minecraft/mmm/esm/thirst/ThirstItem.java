package mmm.esm.thirst;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ThirstItem extends Item {

	
	public ThirstItem(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	public ItemStack turnItemInto(ItemStack itemStack, EntityPlayer player, ItemStack turnToItem)
	{
    	if(itemStack.stackSize-1 == 0)
    	{
    		return turnToItem;
    	}
    	else
    	{
        	if(!player.inventory.addItemStackToInventory(turnToItem))
        	{
        		player.dropPlayerItem(turnToItem);
        	}           	
        	
        	return new ItemStack(itemStack.itemID,itemStack.stackSize-1,itemStack.getItemDamage());
    	}
	}
}
