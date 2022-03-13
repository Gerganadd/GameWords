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
			image = ImageIO.read(new File(GamePaths.START_WINDOW_BACKGROUND_PICTURE_PATH));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			lblImage.setBounds(0, 0, image.getWidth(), image.getHeight());
			
			JButton btnStart = Game.createButton(Buttons.BTN_START_TEXT);
			btnStart.addActionListener(x -> 
			{
				Game.getInstance().openExplanationWindow();
			});
			btnStart.setBounds((image.getWidth() - StartWindowConstants.btnWidth) / 2 ,
					image.getHeight() - StartWindowConstants.btnHeight - 5,
					StartWindowConstants.btnWidth,
					StartWindowConstants.btnHeight);
		
			Game.setSize(this, new Dimension(image.getWidth(), image.getHeight()));
			
			this.add(lblImage);
			this.add(btnStart);
			this.repaint();
			
			Game.getInstance().change();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	private void configurate() 
	{
		this.setLayout(null);
		this.setVisible(true);
	}
}
