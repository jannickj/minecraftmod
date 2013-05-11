package mmm.esm.thirst.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mmm.esm.thirst.ThirstMod;
import mmm.esm.thirst.items.condensator.gui.CondensatorGui;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.world.World;

public class BlockCondensator extends BlockBrewingStand {

	public BlockCondensator(int par1) {
		super(par1);
		setHardness(0.5F);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("condensatorBlock");
		setResistance(10F);
		setStepSound(soundStoneFootstep);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
		super.registerIcons(iconRegister);
		this.blockIcon = iconRegister.registerIcon("ThirstMod:WoodenCondensator");		
    }

	
	@Override
	public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityCondensator();
    }
	
	/**
     * Called upon block activation (right click on the block.)
     */
	@Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
        	TileEntityCondensator tileentitybrewingstand = (TileEntityCondensator)par1World.getBlockTileEntity(x, y, z);

            if (tileentitybrewingstand != null)
            {
            	//Minecraft mc = ModLoader.getMinecraftInstance();
            	//mc.displayGuiScreen(new CondensatorGui(par5EntityPlayer.inventory,tileentitybrewingstand));
            	
            	
            	par5EntityPlayer.openGui(ThirstMod.instance, 0, par1World, x, y, z);
            	
            }

            return true;
        }
    }
	
	
}
