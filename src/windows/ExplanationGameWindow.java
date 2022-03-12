package windows;

import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import constants.*;
import game.Game;

public class ExplanationGameWindow extends JPanel
{
	private final LayoutManager LAYOUT = new BoxLayout(this, BoxLayout.X_AXIS); 
	
	private JPanel pnlInformation = new JPanel();
	private JPanel pnlPlayerWords;
	
	public ExplanationGameWindow()
	{
		super();
		configurate();
		
		try 
		{
			BufferedImage playerImage = ImageIO.read(new File(GameConstants.PLAYER_PICTURE_PATH));
			JLabel lblPlayer = new JLabel(new ImageIcon(playerImage));
			
			this.add(lblPlayer);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		JButton btnYes = new JButton(ButtonTextConstants.BTN_YES_TEXT);
		btnYes.addActionListener(x ->
		{
			Game.getInstance().openGame();
		});
		
		JButton btnExit = new JButton(ButtonTextConstants.BTN_EXIT_TEXT);
		btnExit.addActionListener(y ->
		{
			System.exit(0);
		});
		
		JButton btnNo = new JButton(ButtonTextConstants.BTN_NO_TEXT);
		btnNo.addActionListener(x ->
		{
			pnlInformation.removeAll();
			
			createPnlInformation(ExplanationGameWindowConstants.PLAYER_GOODBYE_WORDS, btnExit);
			
			Game.getInstance().change();
			
		});

		createPnlInformation(ExplanationGameWindowConstants.PLAYER_WORDS, btnYes, btnNo);
		
		this.repaint();
	}
	
	private void createPnlInformation(String text, JButton...buttons)
	{ 
		pnlInformation.setLayout(new BoxLayout(pnlInformation, BoxLayout.Y_AXIS));
		pnlInformation.setBackground(this.getBackground());
		
		pnlPlayerWords = createPnlWords(text);
		Game.setSize(pnlPlayerWords, ExplanationGameWindowConstants.D_START_WINDOW_PNL_TEXT);
		pnlInformation.add(pnlPlayerWords);
		
		JPanel pnlButtons = createPnlButtons(buttons);
		pnlInformation.add(pnlButtons);
		
		this.add(pnlInformation);
	}
	
	private JPanel createPnlButtons(JButton...buttons)
	{
		JPanel pnl = new JPanel(); 
		pnl.setLayout(ExplanationGameWindowConstants.PNL_BUTTON_LAYOUT);
		pnl.setBackground(this.getBackground());
		
		for(int i = 0; i < buttons.length; i++)
		{
			pnl.add(buttons[i]);
		}
		
		return pnl;
	}
	
	private JPanel createPnlWords(String text)
	{
		JPanel pnl = new JPanel();
		
		pnl.setLayout(ExplanationGameWindowConstants.PNL_WORDS_LAYOUT);
		pnl.setBackground(this.getBackground());
		pnl.setBorder(BorderFactory.createLineBorder(this.getBackground()));
		
		String words[] = text.split(" ");
		for (String word : words)
		{
			JLabel lbl = new JLabel(word);
			
			Game.setFont(lbl);
			
			pnl.add(lbl);
		}
		
		return pnl;
	}
	
	private void configurate() 
	{ 
		this.setVisible(true);
		this.setBackground(GameViewConstants.BACKGROUND);
		this.setLayout(LAYOUT);
	}
}
