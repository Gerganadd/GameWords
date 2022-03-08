package windows;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ViewConstants;
import game.Game;
import game_components.Word;

public class WordWindow extends JPanel //to-do add timer
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
		
		createContent();
	}

	private void configurate()
	{
		this.setLayout(WORD_WINDOW_LAYOUT);
		
		pnlText = new JPanel();
		pnlText.setLayout(new FlowLayout());
		
		pnlLetters = new JPanel();
		pnlLetters.setLayout(ViewConstants.LAYOUT);
		
		hasSelectedLetter = false;
	}
	
	private void createContent()
	{
		setText(pnlText, ViewConstants.WORD_WINDOW_QUESTION);
		
		for(int i = 0; i < word.getWrongWord().length(); i++)
		{
			createPanel(i);
		}
		
		this.add(pnlText);
		this.add(pnlLetters);
	}
	
	private void createPanel(int index)
	{
		JLabel lblLetter = createLabelLetter(index);
		
		JPanel pnl = new JPanel();
		pnl.setBorder(ViewConstants.DEFAULT_BORDER);
		pnl.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				if (!hasSelectedLetter)
				{
					pnl.setBorder(ViewConstants.SELECTED_BORDER);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent args0)
			{
				if (!hasSelectedLetter)
				{
					pnl.setBorder(ViewConstants.DEFAULT_BORDER);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				hasSelectedLetter = true;
				
				if (index == word.getIndexOfWrongLetter())
				{
					pnl.setBorder(ViewConstants.CORRECT_SELECTED_BORDER);
					
					correctAnswear();
				}
				else
				{
					pnl.setBorder(ViewConstants.WRONG_SELECTED_BORDER);
					lblLetters[word.getIndexOfWrongLetter()].setForeground(ViewConstants.CORRECT_COLOR);
					
					wrongAnswear();
				}
				
				Game.getInstance().change();
			}
		});
		
		int size = (int) (Game.getInstance().getWindowSize().getHeight() * ViewConstants.PROSENTS_OF_WINDOW_PNL_LETTER);
		Dimension d = new Dimension(size, size);
		Game.setSize(pnl, d);
		
		pnl.add(lblLetter);
		lblLetters[index] = lblLetter;
		pnlLetters.add(pnl);
	}
	
	private JLabel createLabelLetter(int index)
	{
		JLabel lbl = new JLabel(word.getWrongWord().charAt(index) + "");
		changeFont(lbl, ViewConstants.FONT_SIZE_LETTER);
		
		return lbl;
	}
	
	private void changeFont(Component c, float f)
	{
		c.setFont(c.getFont().deriveFont(ViewConstants.FONT, f));
	}
	
	private void correctAnswear()
	{
		this.pnlText.removeAll();
		setText(pnlText, ViewConstants.CORRECT_ANSWEAR);
		
		this.repaint();
	}
	
	private void wrongAnswear()
	{
		Dimension d = new Dimension((int) Game.getInstance().getWindowSize().getWidth() - 20,
				(int) (Game.getInstance().getWindowSize().getHeight() * ViewConstants.PROSENTS_OF_WINDOW_PNL_TEXT));
		
		this.pnlText.removeAll();
		pnlText.setLayout(new FlowLayout());
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
			changeFont(lbl, ViewConstants.FONT_SIZE_TEXT);
			pnl.add(lbl);
		}	
	}
}
