package constants;

import java.awt.Dimension;

public class StartWindowConstants
{
	public static final Dimension D_START_WINDOW = new Dimension(700, 400); 
	
	public static final int btnWidth = 100;
	public static final int btnHeight = 30;
	
	public static final Dimension D_START_WINDOW_PNL_BOTTOM = 
			new Dimension(D_START_WINDOW.width, (int) (D_START_WINDOW.height * 0.2));
	
	public static final Dimension D_START_WINDOW_PNL_TEXT = 
			new Dimension((int) (D_START_WINDOW.getWidth() / 2), D_START_WINDOW.height - D_START_WINDOW_PNL_BOTTOM.height);
}
