package mmm.esm.thirst.gui;

import mmm.esm.thirst.items.condensator.ContainerCondensator;
import mmm.esm.thirst.items.condensator.TileEntityCondensator;
import mmm.esm.thirst.items.condensator.gui.CondensatorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ThirstGuiHandler implements IGuiHandler {


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		switch(ID)
		{
			case 0: return new ContainerCondensator(player.inventory, (TileEntityCondensator)te);
		}
		 
		 return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		
		switch(ID)
		{
			case 0: return new CondensatorGui(player.inventory, (TileEntityCondensator)te);
		}
		 
		 return null;
	}
	
	
	
	
}
