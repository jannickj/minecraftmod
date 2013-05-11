package mmm.esm.thirst.items.condensator.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mmm.esm.thirst.items.condensator.ContainerCondensator;
import mmm.esm.thirst.items.condensator.TileEntityCondensator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class CondensatorGui extends GuiContainer {
	
	private TileEntityCondensator condensator;

	
	public CondensatorGui(InventoryPlayer par1InventoryPlayer, TileEntityCondensator te)
    {
        super(new ContainerCondensator(par1InventoryPlayer, te));
        this.condensator = te;
    }
	





	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/condensator_gui.png");
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1 = this.condensator.getCondensationCurrentTicks();

        if (i1 > 0)
        {
            int j1 = (int)(28.0F * (1.0F - (float)i1 / this.condensator.getCondensationTotalTicks()));

            if (j1 > 0)
            {
                this.drawTexturedModalRect(k + 97, l + 16, 176, 0, 9, j1);
            }

            int k1 = i1 / 2 % 7;

            switch (k1)
            {
                case 0:
                    j1 = 29;
                    break;
                case 1:
                    j1 = 24;
                    break;
                case 2:
                    j1 = 20;
                    break;
                case 3:
                    j1 = 16;
                    break;
                case 4:
                    j1 = 11;
                    break;
                case 5:
                    j1 = 6;
                    break;
                case 6:
                    j1 = 0;
            }

            if (j1 > 0)
            {
                this.drawTexturedModalRect(k + 65, l + 14 + 29 - j1, 185, 29 - j1, 12, j1);
            }
        }
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = "Condensator";
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
}
