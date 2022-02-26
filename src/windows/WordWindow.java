package windows;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ViewConstants;
import game_components.Word;

public class WordWindow extends JPanel
{
	private Word word;
	
	public WordWindow(Word word)
	{
		super();
		configurate();
		
		if (word != null) 
			this.word = word;
		
		JLabel lblWord = new JLabel(word.getWrongWord());
		this.add(lblWord);
		
	}

	private void configurate()
	{
		this.setLayout(ViewConstants.LAYOUT);
		
	}
}
