package mmm.esm.thirst.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mmm.esm.thirst.ThirstMod;
import mmm.esm.thirst.items.CanteenUnfilledItem;
import mmm.esm.thirst.items.PureWaterCupItem;
import mmm.esm.thirst.items.WoodenCupItem;
import mmm.esm.thirst.items.condensator.gui.CondensatorGui;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.world.World;
import mmm.esm.thirst.*;

public class BlockBarrel extends BlockContainer {

	
	public BlockBarrel(int par1) {
		super(par1, Material.wood);
		setHardness(0.5F);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("barrelBlock");
		setResistance(10F);
		setStepSound(soundStoneFootstep);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
		  this.blockIcon = iconRegister.registerIcon("ThirstMod:WoodenCondensator");		
    }

	
	@Override
	public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityBarrel();
    }
	
	/**
     * Called upon block activation (right click on the block.)
     */
	@Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		TileEntityBarrel barrel  = (TileEntityBarrel) par1World.getBlockTileEntity(x, y, z);
		
		ItemStack is = par5EntityPlayer.getCurrentEquippedItem();
		if(is == null || barrel == null)
			return false;
		
		Item itm = is.getItem();
		
		if(itm instanceof PureWaterCupItem)
			return handleWaterCup(barrel, par5EntityPlayer, itm);
		
		if(itm instanceof CanteenUnfilledItem)
			return handleCanteen(barrel, par5EntityPlayer, itm);
		
		if(itm instanceof WoodenCupItem)
			return handleWoodenCup(barrel, par5EntityPlayer, itm);
		
		return false;
    }
	
	private boolean handleWoodenCup(TileEntityBarrel barrel,
			EntityPlayer player, Item itm) {
		
		if(barrel.getWaterlevel() >= 1)
		{
			player.setCurrentItemOrArmor(0, new ItemStack(ThirstMod.PureWaterCup));
			barrel.modWaterlevel(-1);
			return true;
		}
			
		return false;
	}

	private boolean handleCanteen(TileEntityBarrel barrel, EntityPlayer player, Item itm) {
		// TODO Auto-generated method stub
		if(barrel.getWaterlevel() >= 3)
		{
			player.setCurrentItemOrArmor(0, new ItemStack(ThirstMod.canteenFilled));
			barrel.modWaterlevel(-3);
			return true;
		}
			
		return false;
	}

	private boolean handleWaterCup(TileEntityBarrel barrel, EntityPlayer player, Item itmbarrel)
	{
		if(barrel.getWaterlevel()<barrel.getMaxWaterlevel())
		{
			player.setCurrentItemOrArmor(0, new ItemStack(ThirstMod.woodenCup));
			
			barrel.modWaterlevel(1);;
			return true;
		}
		return false;
	}
	
	
	
}
