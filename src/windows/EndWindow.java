package windows;

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
	
	private JLabel lblPlayer = createLblPictureFrom(GamePaths.END_WINDOW_BACKGROUND_PICTURE_1_PATH);
	private JLabel lblPlayerWords = createLblPictureFrom(GamePaths.END_WINDOW_BACKGROUND_PICTURE_2_PATH);;
	
	public EndWindow()
	{
		super();
		configurate();
		
		JPanel pnlPlayer = new JPanel();
		pnlPlayer.setLayout(null);
		pnlPlayer.setBounds(0, 0, lblPlayer.getWidth(), lblPlayer.getHeight());
		pnlPlayer.add(lblPlayer);
		
		JPanel pnlPlayerWords = new JPanel();
		pnlPlayerWords.setLayout(null);
		pnlPlayerWords.setBounds(pnlPlayer.getWidth(), 0, lblPlayerWords.getWidth(), lblPlayerWords.getHeight());
		addResultLabelInto(lblPlayerWords);
		
		JButton btnExit = new JButton(ButtonTextConstants.BTN_EXIT_TEXT);
		btnExit.addActionListener(x ->
		{
			System.exit(0);
		});
		btnExit.setVisible(true);
		btnExit.setBounds(
				(lblPlayerWords.getWidth() - EndWindowConstants.BTN_WIDTH) / 2 - 30,
				lblPlayerWords.getHeight() - 2 * EndWindowConstants.BTN_HEIGHT,
				EndWindowConstants.BTN_WIDTH,
				EndWindowConstants.BTN_HEIGHT);
		
		lblPlayerWords.add(btnExit);
		pnlPlayerWords.add(lblPlayerWords);
		
		Game.setSize(this, 
				new Dimension(
						lblPlayer.getWidth() + lblPlayerWords.getWidth(),
						lblPlayerWords.getHeight()));
		
		this.add(pnlPlayer);
		this.add(pnlPlayerWords);
		
		this.repaint();
	}
	
	private JLabel createLblPictureFrom(String path)
	{	
		
		try 
		{
			BufferedImage image = ImageIO.read(new File(path));
			
			JLabel lbl = new JLabel(new ImageIcon(image));
			lbl.setBounds(0, 0, image.getWidth(), image.getHeight());
			lbl.setVisible(true);
			
			return lbl;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return new JLabel();	
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
