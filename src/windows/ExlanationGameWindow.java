package windows;

import java.awt.Color;
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

public class ExlanationGameWindow extends JPanel
{
	private final LayoutManager LAYOUT = new BoxLayout(this, BoxLayout.X_AXIS); 
	
	private JPanel pnlInformation = new JPanel();
	private JPanel pnlPlayerWords;
	
	public ExlanationGameWindow()
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
		
		JButton btnYes = new JButton(ViewConstants.BTN_YES_TEXT);
		btnYes.addActionListener(x ->
		{
			Game.getInstance().openGame();
		});
		
		JButton btnExit = new JButton(ViewConstants.BTN_EXIT_TEXT);
		btnExit.addActionListener(y ->
		{
			System.exit(0);
		});
		
		JButton btnNo = new JButton(ViewConstants.BTN_NO_TEXT);
		btnNo.addActionListener(x ->
		{
			pnlInformation.removeAll();
			
			createPnlInformation(ViewConstants.PLAYER_GOODBYE_WORDS, btnExit);
			
			Game.getInstance().change();
			
		});

		createPnlInformation(ViewConstants.PLAYER_WORDS, btnYes, btnNo);
		
		this.repaint();
	}
	
	private void createPnlInformation(String text, JButton...buttons)
	{ 
		pnlInformation.setLayout(new BoxLayout(pnlInformation, BoxLayout.Y_AXIS));
		pnlInformation.setBackground(this.getBackground());
		
		pnlPlayerWords = createPnlWords(text);
		Game.setSize(pnlPlayerWords, ViewConstants.D_START_WINDOW_PNL_TEXT);

		pnlInformation.add(pnlPlayerWords);
		
		JPanel pnlButtons = createPnlButtons(buttons);
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlButtons.setBackground(this.getBackground());
		
		pnlInformation.add(pnlButtons);
		
		this.add(pnlInformation);
	}
	
	private JPanel createPnlButtons(JButton...buttons)
	{
		JPanel pnl = new JPanel(); 
		pnl.setLayout(new FlowLayout(FlowLayout.CENTER));
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
		
		pnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl.setBackground(this.getBackground());
		pnl.setBorder(BorderFactory.createLineBorder(this.getBackground()));
		
		String words[] = text.split(" ");
		for (String word : words)
		{
			JLabel lbl = new JLabel(word);
			
			lbl.setForeground(Color.WHITE);
			lbl.setFont(lbl.getFont().deriveFont(ViewConstants.FONT, ViewConstants.FONT_SIZE_TEXT));
			
			pnl.add(lbl);
		}
		
		return pnl;
	}
	
	private void configurate() 
	{ 
		this.setVisible(true);
		this.setBackground(ViewConstants.BACKGROUND);
		this.setLayout(LAYOUT);
	}
}
