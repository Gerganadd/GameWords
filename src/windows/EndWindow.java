package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import constants.*;
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
		
		/*
		JLabel lblPlayer = createLblPictureFrom(EndWindowConstants.BACKGROUND_PICTURE_2_PATH);
		pnlPlayer.setBounds(0, 0, lblPlayer.getWidth(), lblPlayer.getHeight());
		pnlPlayer.add(lblPlayer);
		
		
		JLabel lblWords = createLblPictureFrom(EndWindowConstants.BACKGROUND_PICTURE_3_PATH);
		pnlPlayerWords.setBounds(pnlPlayer.getWidth(), 0, lblWords.getWidth(), lblWords.getHeight());
		
		addResultLabelInto(lblWords);
		
		JButton btnExit = new JButton(ButtonTextConstants.BTN_EXIT_TEXT);
		btnExit.setBounds((lblWords.getWidth() - 100) / 2 - 30, lblWords.getHeight() - 60, 100, 30);
		btnExit.setVisible(true);
		btnExit.addActionListener(x ->
		{
			System.exit(0);
		});
		lblWords.add(btnExit);
		
		pnlPlayerWords.add(lblWords);
		
		Game.setSize(this, 
				new Dimension(
						pnlPlayer.getWidth() + pnlPlayerWords.getWidth(),
						pnlPlayer.getHeight()));
		*/
		
		try 
		{
			
			//player picture
			BufferedImage background_2 = ImageIO.read(new File(EndWindowConstants.BACKGROUND_PICTURE_2_PATH));
			JLabel lblBackground_2 = new JLabel(new ImageIcon(background_2));
			lblBackground_2.setBounds(0, 0, background_2.getWidth(), background_2.getHeight());
			lblBackground_2.setVisible(true);
			
			pnlPlayer.setBounds(0, 0, background_2.getWidth(), background_2.getHeight());
			pnlPlayer.add(lblBackground_2);
			
			//background picture
			BufferedImage background_3 = ImageIO.read(new File(EndWindowConstants.BACKGROUND_PICTURE_3_PATH));
			JLabel lblBackground_3 = new JLabel(new ImageIcon(background_3));
			lblBackground_3.setBounds(0, 0, background_3.getWidth(), background_3.getHeight());
			
			pnlPlayerWords.setBounds(pnlPlayer.getWidth(), 0, background_3.getWidth(), background_3.getHeight());
			
			addResultLabelInto(lblBackground_3);
			
			JButton btnExit = new JButton(ButtonTextConstants.BTN_EXIT_TEXT);
			btnExit.setBounds((background_3.getWidth() - EndWindowConstants.BTN_WIDTH) / 2 - 30, background_3.getHeight() - 2 * EndWindowConstants.BTN_HEIGHT, EndWindowConstants.BTN_WIDTH, EndWindowConstants.BTN_HEIGHT);
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
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.add(pnlPlayer);
		this.add(pnlPlayerWords);
		
		this.repaint();
	}
	
	private JLabel createLblPictureFrom(String path)
	{
		BufferedImage image = null;
		
		try 
		{
			image = ImageIO.read(new File(path));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		JLabel lbl = new JLabel(new ImageIcon(image));
		lbl.setBounds(0, 0, image.getWidth(), image.getHeight());
		lbl.setVisible(true);
		
		return lbl;
	}

	private void addResultLabelInto(JLabel lbl) 
	{
		JLabel lblPoints = new JLabel(EndWindowConstants.END_TEXT + Game.getInstance().getPoints());
		lblPoints.setBounds(0, EndWindowConstants.TEXT_Y, lbl.getWidth(), EndWindowConstants.TEXT_HEIGHT);
		Game.setFont(lblPoints);
		
		lbl.add(lblPoints);
		
		JLabel lblPlayerWords = new JLabel(playerWords); 
		int y = lblPoints.getHeight() + lblPoints.getY();
		lblPlayerWords.setBounds(0, y, lbl.getWidth(), EndWindowConstants.TEXT_HEIGHT);
		Game.setFont(lblPlayerWords);

		lbl.add(lblPlayerWords);
	}

	private void configurate() 
	{
		this.setLayout(null);
		
		switch(Game.getInstance().getPoints())
		{
			case 10: 
				playerWords = EndWindowConstants.RESULT_TEXT_10_POINTS;
				break;
			case 9: 
				playerWords = EndWindowConstants.RESULT_TEXT_9_POINTS;
				break;
			case 8: 
				playerWords = EndWindowConstants.RESULT_TEXT_8_POINTS;
				break;
			case 7: 
				playerWords = EndWindowConstants.RESULT_TEXT_7_POINTS;
				break;
			default: 
				playerWords = EndWindowConstants.RESULT_TEXT_6_POINTS;
				break;
			
		}
	}

}
