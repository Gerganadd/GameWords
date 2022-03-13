package windows;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import constants.*;
import game.Game;

public class StartGameWindow extends JPanel
{
	private BufferedImage image;
	
	public StartGameWindow()
	{
		super();
		configurate();
		
		try 
		{
			image = ImageIO.read(new File(StartWindowConstants.GAME_TITLE_PICTURE_PATH));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			lblImage.setBounds(0, 0, image.getWidth(), image.getHeight());
			
			JButton btnStart = new JButton(ButtonTextConstants.BTN_START_TEXT);
			btnStart.setVisible(true);
			btnStart.addActionListener(x -> 
			{
				Game.getInstance().openExplanationWindow();
			});
			btnStart.setBounds((image.getWidth() - StartWindowConstants.btnWidth) / 2 ,
					image.getHeight() - StartWindowConstants.btnHeight - 5,
					StartWindowConstants.btnWidth,
					StartWindowConstants.btnHeight);
			
			this.add(lblImage);
			this.add(btnStart);
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Game.setSize(this, new Dimension(image.getWidth(), image.getHeight()));

		Game.getInstance().change();
	}
	
	private void configurate() 
	{
		this.setLayout(null);
		this.setVisible(true);
	}
}
