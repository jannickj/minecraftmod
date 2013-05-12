package core.thirst;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.GuiIngameForge;

public class ThirstGuiOverLay extends GuiIngameForge {

	private ThirstGui thirst;

	
	public ThirstGuiOverLay(Minecraft mc) {
		super(mc);
		thirst = new ThirstGui(new ThirstIconCollection());
	}
	
	@Override
    public void renderGameOverlay(float partialTicks, boolean hasScreen, int mouseX, int mouseY)
    {
		ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		int width = res.getScaledWidth();
        int height = res.getScaledHeight();
		
		super.renderGameOverlay(partialTicks, hasScreen, mouseX, mouseY);
		if (!mc.playerController.enableEverythingIsScrewedUpMode())
        {
            if (this.mc.playerController.shouldDrawHUD())
            {
            	renderThirst(width,height);
            }
        }
    }
	
	@Override
	protected void renderAir(int width, int height)
    {
        super.renderAir(width, height-10);
    }
	
	private void renderThirst(int width, int height) 
    {
    	int left = width / 2 + 91;
        int top = height - 49;
    	mc.renderEngine.bindTexture("/thirstBar.png");
    	thirst.Draw(this.mc.thePlayer.getThirstStats(), this, left, top);
		
	}

}
