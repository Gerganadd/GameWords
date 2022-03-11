package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import constants.GameConstants;
import constants.ViewConstants;
import game.Game;

public class EndWindow extends JPanel
{
	private String playerWords;
	
	public EndWindow()
	{
		super();
		configurate();
		
		JPanel pnlPlayer = new JPanel();
		pnlPlayer.setLayout(null);
		
		JPanel pnlPlayerWords = new JPanel();
		pnlPlayerWords.setLayout(null);
		
		try 
		{
			//player picture
			BufferedImage background_2 = ImageIO.read(new File(GameConstants.BACKGROUND_PICTURE_2_PATH));
			JLabel lblBackground_2 = new JLabel(new ImageIcon(background_2));
			lblBackground_2.setBounds(0, 0, background_2.getWidth(), background_2.getHeight());
			lblBackground_2.setVisible(true);
			
			pnlPlayer.setBounds(0, 0, background_2.getWidth(), background_2.getHeight());
			pnlPlayer.add(lblBackground_2);
			
			//background picture
			BufferedImage background_3 = ImageIO.read(new File(GameConstants.BACKGROUND_PICTURE_3_PATH));
			JLabel lblBackground_3 = new JLabel(new ImageIcon(background_3));
			lblBackground_3.setBounds(0, 0, background_3.getWidth(), background_3.getHeight());
			
			pnlPlayerWords.setBounds(pnlPlayer.getWidth(), 0, background_3.getWidth(), background_3.getHeight());
			
			addResultLabelInto(lblBackground_3);
			
			JButton btnExit = new JButton(ViewConstants.BTN_EXIT_TEXT);
			btnExit.setBounds((background_3.getWidth() - 100) / 2 - 30, background_3.getHeight() - 60, 100, 30);
			btnExit.setVisible(true);
			btnExit.addActionListener(x ->
			{
				System.exit(0);
			});
			lblBackground_3.add(btnExit);
			
			pnlPlayerWords.add(lblBackground_3);
			
			Game.setSize(this, 
					new Dimension(
							background_2.getWidth() + background_3.getWidth(),
							background_2.getHeight()));
			
			System.out.println(new Dimension(
							background_2.getWidth() + background_3.getWidth(),
							background_2.getHeight()));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.add(pnlPlayer);
		this.add(pnlPlayerWords);
		
		this.repaint();
	}

	private void addResultLabelInto(JLabel lblBackground_3) 
	{
		JLabel lblPoints = new JLabel(ViewConstants.END_TEXT + Game.getInstance().getPoints());
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(lblPoints.getFont().deriveFont(ViewConstants.FONT, ViewConstants.FONT_SIZE_TEXT));
		lblPoints.setBounds(0, 30, lblBackground_3.getWidth(), 30);
		
		lblBackground_3.add(lblPoints);
		
		JLabel lblPlayerWords = new JLabel(playerWords); 
		int y = lblPoints.getHeight() + lblPoints.getY();
		
		lblPlayerWords.setBounds(0, y, lblBackground_3.getWidth(), 30);
		lblPlayerWords.setForeground(Color.WHITE);
		lblPlayerWords.setFont(lblPlayerWords.getFont().deriveFont(ViewConstants.FONT, ViewConstants.FONT_SIZE_TEXT));
		
		lblBackground_3.add(lblPlayerWords);
	}

	private void configurate() 
	{
		this.setLayout(null);
		
		switch(Game.getInstance().getPoints())
		{
			case 10: 
				playerWords = ViewConstants.RESULT_TEXT_10_POINTS;
				break;
			case 9: 
				playerWords = ViewConstants.RESULT_TEXT_9_POINTS;
				break;
			case 8: 
				playerWords = ViewConstants.RESULT_TEXT_8_POINTS;
				break;
			case 7: 
				playerWords = ViewConstants.RESULT_TEXT_7_POINTS;
				break;
			default: 
				playerWords = ViewConstants.RESULT_TEXT_6_POINTS;
				break;
			
		}
	}

}
