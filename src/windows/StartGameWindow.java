package windows;

import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import constants.GameConstants;
import constants.ViewConstants;
import game.Game;

public class StartGameWindow extends JPanel
{
	private final LayoutManager LAYOUT = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	public StartGameWindow()
	{
		super();
		configurate();
		
		try 
		{
			BufferedImage image = ImageIO.read(new File(GameConstants.BACKGROUND_PICTURE_PATH));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			this.add(lblImage);
			
			JButton btnStart = new JButton(ViewConstants.BTN_START_TEXT);
			btnStart.addActionListener(x -> 
			{
				//to-do
			});
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	private void configurate() 
	{
		this.setLayout(LAYOUT);
		
	}
}
