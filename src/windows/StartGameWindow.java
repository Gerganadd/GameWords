package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
			BufferedImage image = ImageIO.read(new File(GameConstants.GAME_TITLE_PICTURE_PATH));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			this.add(lblImage);
			
			JPanel pnlButtons = new JPanel();
			pnlButtons.setBackground(Color.blue);
			
			pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			JButton btnStart = new JButton(ViewConstants.BTN_START_TEXT);
			btnStart.addActionListener(x -> 
			{
				Game.getInstance().openExplanationWindow();
			});
			
			pnlButtons.add(btnStart);
			
			//this.add(pnlButtons);
			this.add(btnStart);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.repaint();
	}

	private void configurate() 
	{
		this.setLayout(LAYOUT);
		
	}
}
