package interfaces;

import game_components.Word;

public interface IGame 
{
	public void start();
	public void openExplanationWindow();
	public void openGame();
	public void openWordWindow(Word w);
	public void change();
	public void end();
}
