package interfaces;

import game_components.Word;

public interface IGame 
{
	public void start();
	public void openGame();
	public void end();
	public void change();
	public void openWordWindow(Word w);
}
