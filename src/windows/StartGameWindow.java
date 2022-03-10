package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private static final int btnWidth = 100;
	private static final int btnHeight = 30;
	
	private BufferedImage image;
	
	public StartGameWindow()
	{
		super();
		configurate();
		
		try 
		{
			image = ImageIO.read(new File(GameConstants.GAME_TITLE_PICTURE_PATH));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			lblImage.setBounds(0, 0, image.getWidth(), image.getHeight());
			
			JButton btnStart = new JButton(ViewConstants.BTN_START_TEXT);
			btnStart.addActionListener(x -> 
			{
				Game.getInstance().openExplanationWindow();
			});
			btnStart.setBounds((image.getWidth() - btnWidth) / 2 ,
					image.getHeight() - btnHeight - 5,
					btnWidth,
					btnHeight);
			
			this.add(lblImage);
			this.add(btnStart);

			Game.getInstance().change();
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Game.setSize(this, new Dimension(image.getWidth(), image.getHeight()));
		this.repaint();
	}
	
	private void configurate() 
	{
		this.setLayout(null);
		this.setVisible(true);
	}
}
