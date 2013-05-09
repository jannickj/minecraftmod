package mmm.esm.thirst.gui;

import java.awt.Point;
import java.awt.Rectangle;

import mmm.esm.thirst.ThirstStats;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.profiler.Profiler;

public class ThirstGui {

	private ThirstIconCollection iconcon;
	
	public ThirstGui(ThirstIconCollection iconcon)
	{
		this.iconcon = iconcon;
	}
	
	public void Draw(ThirstStats thirstmodel, Gui gui, int x, int y)
	{
		
		int filledcount = thirstmodel.getInterval();
		
		int unfilled = thirstmodel.getLastIntervals() - filledcount;
		
		for(int i = 1; i <= filledcount;i++)
		{
			//drawicon(gui, x-i*iconcon.getIconWidth(), y, iconcon.getIcon(ThirstIcons.WaterDropShadow));
			drawicon(gui, x-i*iconcon.getIconWidth(), y, iconcon.getIcon(ThirstIcons.WaterDrop));
			
		}
		for(int i = filledcount+1; i<= thirstmodel.getLastIntervals(); i++)
		{
			drawicon(gui, x-i*iconcon.getIconWidth(), y, iconcon.getIcon(ThirstIcons.WaterDropEmpty));
		}

	}
	
	private void drawicon(Gui gui,int x, int y, Rectangle icon)
	{
		gui.drawTexturedModalRect(x, y, icon.x, icon.y, icon.width, icon.height);
	}
}
