package windows;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import constants.GameConstants;
import game.Game;
import game_components.*;

public class MainWindow extends JPanel
{
	private Graphics2D g;
	private BufferedImage backgroundImage;
	public BufferedImage elementImage;
	
	public MainWindow()
	{
		super();
		configurate();
		
		try 
		{
			backgroundImage = ImageIO.read(new File(GameConstants.BACKGROUND_PICTURE_PATH));
			elementImage = ImageIO.read(new File(GameConstants.ELEMENT_PICTURE_PATH));
			
			Dimension d = new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight());
			Game.setSize(this, d);
			
			Map<Word, Coordinate> info = Game.getInstance().getInfo();
			info.forEach((k, v) -> 
			{
				JLabel lbl = new JLabel(new ImageIcon(elementImage));
				lbl.setBounds(v.getX(), v.getY(), elementImage.getWidth(), elementImage.getHeight());
				lbl.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent arg0) 
					{
						Game.getInstance().addWordWindow(k);
					}
				});
				this.add(lbl);
			});
			
			
			
			//to-do: remove mouseListener
			this.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					System.out.println(arg0.getLocationOnScreen());
				}
			});
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
    protected void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        this.g = (Graphics2D) g.create();
        
        if (backgroundImage != null)
        {
            this.g.drawImage(backgroundImage, 0, 0, this);
        }
       
        this.g.dispose();
        
    }
	
	private void configurate() 
	{
		this.setVisible(true);
		this.setLayout(null);
	}
}
