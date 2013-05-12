package core.thirst;

import java.awt.Rectangle;

public class ThirstIconCollection
{	
	
	private int iconwidth = 9;
	private int iconheight = 9;
	//private int spacebetween_levels = 1;
	private int level1 = 54;
	//private int level2 = level1 + iconheight + spacebetween_levels;
	
	
	public Rectangle getIcon(ThirstIcons ticon)
	{
		switch(ticon)
		{
//		case PoisonedDrop:
//			return new Rectangle(88, level1, iconwidth, iconheight);
//		case PoisonedShadow:
//			break;
//		case PureWaterDrop:
//			break;
//		case PureWaterDropShadow:
//			break;
		case WaterDrop:
			return new Rectangle(16, level1, iconwidth, iconheight);
		case WaterDropEmpty:
			return new Rectangle(26, level1, iconwidth, iconheight);
		default:
			break;
		
		}
		
		return null;
	}


	public int getIconWidth() {
		return iconwidth;
	}
}
