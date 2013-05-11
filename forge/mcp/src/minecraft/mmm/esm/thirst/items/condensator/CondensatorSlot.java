package mmm.esm.thirst.items.condensator;

import mmm.esm.thirst.blocks.TileEntityCondensator;
import mmm.esm.thirst.items.PureWaterCupItem;
import mmm.esm.thirst.items.UnfilteredWaterCupItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CondensatorSlot extends Slot {

	private TileEntityCondensator condensator;
	private int slotid;
	
	public CondensatorSlot(TileEntityCondensator condensator, int slotid, int par3,
			int par4) {
		super(condensator, slotid, par3, par4);

		this.condensator = condensator;
		this.slotid = slotid;
	}

	public int getSlotStackLimit()
    {
        return 1;
    }

	public boolean isItemValid(ItemStack par1ItemStack)
    {	
        return this.condensator.isStackValidForSlot(slotid, par1ItemStack);
    }
	
}
