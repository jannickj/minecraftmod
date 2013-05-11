package mmm.esm.thirst.items.condensator;

import mmm.esm.thirst.ThirstLoader;
import mmm.esm.thirst.items.PureWaterCupItem;
import mmm.esm.thirst.items.UnfilteredWaterCupItem;
import mmm.esm.thirst.items.WoodenCupItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;

public class TileEntityCondensator extends TileEntity  implements ISidedInventory
{

	public static final String Name = "container.condensator";
	
	private ItemStack[] condensatorItemStacks = new ItemStack[2];
	
	private int currentTick = 0;
	private boolean condensating = false;

	
	public int getCondensationTotalTicks()
	{
		return 400;
	}
	
	public int getCondensationCurrentTicks()
	{
		return currentTick;
	}
	
	public boolean isCondensating()
	{
		return condensating;
	}
	
	public boolean canCondensate()
	{
		ItemStack stack0 = getStackInSlot(0);
		ItemStack stack1 = getStackInSlot(1);
		if(stack0 == null || stack1 == null)
			return false;
		
		Item itm0 = stack0.getItem();
		Item itm1 = stack1.getItem();
		return itm0 instanceof UnfilteredWaterCupItem && itm1 instanceof WoodenCupItem;
	}
	
	
	@Override
	public void updateEntity()
	{
		if(!canCondensate())
		{
			currentTick = this.getCondensationTotalTicks();
			condensating = false;
			return;
		}
		
		if(condensating)
		{
			if(currentTick == 0)
			{
				setInventorySlotContents(1, new ItemStack(ThirstLoader.PureWaterCup));
				setInventorySlotContents(0, new ItemStack(ThirstLoader.woodenCup));
				condensating = false;
			}
			else
				currentTick--;
		}
		else
		{
			currentTick = this.getCondensationTotalTicks();
			condensating = true;

		}
		
	}
	
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return condensatorItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return i >= 0 && i < this.condensatorItemStacks.length ? this.condensatorItemStacks[i] : null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (i >= 0 && i < this.condensatorItemStacks.length)
        {
            ItemStack itemstack = this.condensatorItemStacks[i];
            this.condensatorItemStacks[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack par2ItemStack)
    {
        if (i >= 0 && i < this.condensatorItemStacks.length)
        {
            this.condensatorItemStacks[i] = par2ItemStack;
        }
    }

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		
		Item item = itemstack.getItem();
		if(item == null)
			return false;
		
		if(item instanceof WoodenCupItem)
			return true;
		
		switch(i)
		{
		case 0:
			return item instanceof UnfilteredWaterCupItem;
		case 1:
			return item instanceof PureWaterCupItem;
		}
		return false;
		
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return this.isStackValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        this.condensatorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.condensatorItemStacks.length)
            {
                this.condensatorItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.currentTick = par1NBTTagCompound.getInteger("condensator_current_ticks");
        this.condensating = par1NBTTagCompound.getBoolean("condensator_is_condensating");
    }
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("condensator_current_ticks", this.currentTick);
        par1NBTTagCompound.setBoolean("condensator_is_condensating", this.condensating);
        
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.condensatorItemStacks.length; ++i)
        {
            if (this.condensatorItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.condensatorItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        
        par1NBTTagCompound.setTag("Items", nbttaglist);
    }


}
