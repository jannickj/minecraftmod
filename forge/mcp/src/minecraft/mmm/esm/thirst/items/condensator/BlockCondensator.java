package mmm.esm.thirst.items.condensator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCondensator extends Block {

	public BlockCondensator(int par1) {
		super(par1, Material.wood);
		setHardness(0.5F);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("condensatorBlock");
		setResistance(10F);
		setStepSound(soundStoneFootstep);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
		  this.blockIcon = iconRegister.registerIcon("ThirstMod:WoodenCondensator");		
    }

}
