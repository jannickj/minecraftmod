package mmm.esm.thirst.dispenserbehavior;

import mmm.esm.thirst.ThirstMod;
import mmm.esm.thirst.blocks.BlockBarrel;
import mmm.esm.thirst.blocks.TileEntityBarrel;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class PureWaterCupDispenserBehavior implements IBehaviorDispenseItem {

	@Override
	public ItemStack dispense(IBlockSource iblocksource, ItemStack itemstack) {
		//TileEntity barrel = iblocksource.getBlockTileEntity();
		
		
		
		EnumFacing enumfacing = BlockDispenser.getFacing(iblocksource.getBlockMetadata());
		
		int x = iblocksource.getXInt() + enumfacing.getFrontOffsetX();
		int y = iblocksource.getYInt() + enumfacing.getFrontOffsetY();
		int z = iblocksource.getZInt() + enumfacing.getFrontOffsetZ();
		
		TileEntity barrel  = iblocksource.getWorld().getBlockTileEntity(x, y, z);
		
		if(barrel instanceof TileEntityBarrel)
		{
			((TileEntityBarrel) barrel).modWaterlevel(1);
		}
		return new ItemStack(ThirstMod.woodenCup);
	}

}
