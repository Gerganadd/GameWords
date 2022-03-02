package windows;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game_components.Word;

public class ExplanationWindow extends JPanel
{
	public ExplanationWindow(Word w)
	{
		super();
		this.setLayout(new FlowLayout());
		
		if (w != null)
		{
			JLabel lbl = new JLabel(w.getExplanation());
			this.add(lbl);
		}
	}
}
