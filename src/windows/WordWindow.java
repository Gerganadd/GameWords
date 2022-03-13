package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.*;
import game.Game;
import game_components.Word;

public class WordWindow extends JPanel 
{
	private final LayoutManager WORD_WINDOW_LAYOUT = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	private Word word;
	
	private JPanel pnlText;
	private JPanel pnlLetters;
	private JLabel[] lblLetters;
	
	private boolean hasSelectedLetter;
	
	public WordWindow(Word word)
	{
		super();
		
		configurate();
		
		if (word != null) 
			this.word = word;

		lblLetters = new JLabel[word.getWrongWord().length()];
		
		setText(pnlText, WordWindowConstants.WORD_WINDOW_QUESTION);
		
		for(int i = 0; i < word.getWrongWord().length(); i++)
		{
			createPanelLetter(i);
		}
		
		this.add(createPanelText());
		this.add(pnlLetters);
	}
	
	private void configurate()
	{
		this.setBackground(GameViewConstants.BACKGROUND);
		this.setLayout(WORD_WINDOW_LAYOUT);
		
		pnlText = new JPanel();
		pnlText.setBackground(this.getBackground());
		pnlText.setLayout(new FlowLayout());
		
		pnlLetters = new JPanel();
		pnlLetters.setLayout(new FlowLayout());
		pnlLetters.setBackground(this.getBackground());
		
		hasSelectedLetter = false;
	}
	
	private void createPanelLetter(int index)
	{
		JLabel lblLetter = createLabelLetter(index);
		
		JPanel pnl = new JPanel();
		pnl.setBorder(WordWindowConstants.DEFAULT_BORDER);
		pnl.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				if (!hasSelectedLetter)
				{
					pnl.setBorder(WordWindowConstants.SELECTED_BORDER);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent args0)
			{
				if (!hasSelectedLetter)
				{
					pnl.setBorder(WordWindowConstants.DEFAULT_BORDER);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				hasSelectedLetter = true;
				
				if (index == word.getIndexOfWrongLetter())
				{
					pnl.setBorder(WordWindowConstants.CORRECT_SELECTED_BORDER);
					
					correctAnswer();
				}
				else
				{
					pnl.setBorder(WordWindowConstants.WRONG_SELECTED_BORDER);
					lblLetters[word.getIndexOfWrongLetter()].setForeground(WordWindowConstants.CORRECT_COLOR);
					
					wrongAnswer();
				}
				
				JPanel pnlButton = new JPanel();
				pnlButton.setBackground(getBackground());
				
				JButton btnBack = new JButton(ButtonTextConstants.BTN_BACK_TEXT);
				btnBack.addActionListener(x ->
				{
					Game.getInstance().openGame();
				});
				
				pnlButton.add(btnBack);
				add(pnlButton);
				
				Game.getInstance().change();
			}
		});
		
		int size = (int) (Game.getInstance().getWindowSize().getHeight() * WordWindowConstants.PROSENTS_OF_WINDOW_PNL_LETTER);
		Dimension d = new Dimension(size, size);
		Game.setSize(pnl, d);
		
		pnl.add(lblLetter);
		lblLetters[index] = lblLetter;
		pnlLetters.add(pnl);
	}
	
	private JLabel createLabelLetter(int index)
	{
		JLabel lbl = new JLabel(word.getWrongWord().charAt(index) + "");
		lbl.setFont(lbl.getFont().deriveFont(GameViewConstants.FONT, WordWindowConstants.FONT_SIZE_LETTER));
		
		return lbl;
	}
	
	private void correctAnswer()
	{
		Game.getInstance().plusOnePoint();
		
		this.pnlText.removeAll();
		setText(pnlText, WordWindowConstants.CORRECT_ANSWEAR);
		
		try 
		{
			BufferedImage rewardImage = ImageIO.read(new File(WordWindowConstants.REWARD_PICTURE_PATH));
			pnlText.add(new JLabel(new ImageIcon(rewardImage)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		this.repaint();
	}
	
	private void wrongAnswer()
	{
		this.pnlText.removeAll();
		
		Dimension d = new Dimension((int) Game.getInstance().getWindowSize().getWidth() / 2,
				(int) (Game.getInstance().getWindowSize().getHeight() * WordWindowConstants.PROSENTS_OF_WINDOW_PNL_TEXT));
	
		Game.setSize(pnlText, d);
		
		setText(pnlText, word.getExplanation());
		
		this.repaint();
	}
	
	private void setText(JPanel pnl, String text) 
	{
		String words[] = text.split(" ");
		for (String word : words)
		{
			JLabel lbl = new JLabel(word);
			Game.setFont(lbl);
			
			pnl.add(lbl);
		}	
	}
	
	private JPanel createPanelText()
	{
		JPanel pnl = new JPanel();
		pnl.setBackground(this.getBackground());
		pnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		try 
		{
			BufferedImage playerImage = ImageIO.read(new File(GameConstants.PLAYER_PICTURE_PATH));
			JLabel lblPlayerImage = new JLabel(new ImageIcon(playerImage));
			
			pnl.add(lblPlayerImage);
		
			pnl.add(pnlText);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return pnl;
	}
}
