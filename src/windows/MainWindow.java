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
import constants.ViewConstants;
import game.Game;
import game_components.*;

public class MainWindow extends JPanel
{
	private Graphics2D g;
	private BufferedImage backgroundImage;
	private BufferedImage elementImage;
	private BufferedImage selectedElementImage;
	
	public MainWindow()
	{
		super();
		configurate();
		
		try 
		{
			backgroundImage = ImageIO.read(new File(GameConstants.BACKGROUND_PICTURE_PATH));
			elementImage = ImageIO.read(new File(GameConstants.ELEMENT_PICTURE_PATH));
			selectedElementImage = ImageIO.read(new File(GameConstants.SELECTED_ELEMENT_PICTURE_PATH));
			
			Dimension d = new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight());
			Game.setSize(this, d);
			
			drawElements(Game.getInstance().getInfo(), true);
			drawElements(Game.getInstance().getSelectedWords(), false);
			
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
        
        if (Game.getInstance().getInfo().size() == 0)
        {
        	Game.getInstance().end();
        }
       
        this.g.dispose();
        
    }
	
	public Dimension getSize()
	{
		return new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight());
	}
	
	private void configurate() 
	{
		this.setVisible(true);
		this.setLayout(null);
	}
	
	private void drawElements(Map<Word, Coordinate> map, boolean isDefaultPicture)
	{
		map.forEach((k, v) -> 
		{
			BufferedImage image = isDefaultPicture ? elementImage : selectedElementImage;
			JLabel lbl = new JLabel(new ImageIcon(image));
			lbl.setBounds(v.getX(), v.getY(), image.getWidth(), image.getHeight());
			
			if (isDefaultPicture)
			{
				lbl.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent arg0) 
					{
						Game.getInstance().openWordWindow(k);
					}
				});
			}
			
			this.add(lbl);
		});
	}
	
}
