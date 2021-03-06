package game;

import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.*;
import game_components.*;
import interfaces.IGame;
import parser.Parser;
import windows.*;

public class Game implements IGame
{
	
	private static Game game = null;
	
	private int points = 0;
	
	private Dimension size;
	
	private Map<Word, Coordinate> info = Parser.parse(GamePaths.FILE_PATH); 
	private Map<Word, Coordinate> selectedWords = new HashMap<>();
	private JFrame window;
	
	public Game()
	{
		System.setProperty("file.encoding", "UTF-8");
		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(GameViewConstants.BACKGROUND);
		window.setLayout(GameViewConstants.LAYOUT);
	}
	
	public static Game getInstance()
	{
		if (game == null)
		{
			game = new Game();
		}
		
		return game;
	}
	
	public static void setSize(Component c, Dimension d)
	{
		c.setSize(d);
		c.setPreferredSize(d);
		c.setMinimumSize(d);
		c.setMaximumSize(d);
	}
	
	public static void setFont(JLabel lbl)
	{
		lbl.setForeground(GameViewConstants.FOREGROUND);
		lbl.setFont(lbl.getFont().deriveFont(GameViewConstants.FONT, GameViewConstants.FONT_SIZE_TEXT));
	}
	
	public static JButton createButton(Buttons value)
	{
		JButton btn = new JButton(value.getText());
		btn.setBackground(GameViewConstants.BUTTONS_BACKGROUND);
		btn.setVisible(true);
		
		return btn;
	}
	
	@Override
	public void start()
	{
		openWindow(new StartGameWindow());
	}
	
	@Override
	public void openExplanationWindow()
	{
		openWindow(new ExplanationGameWindow());
	}
	
	@Override
	public void openGame()
	{
		openWindow(new MainWindow());
		
		size = window.getSize();
	}
	
	@Override
	public void openWordWindow(Word w) 
	{
		openWindow(new WordWindow(w));
		
		setSize(window, size);
		
		selectedWords.put(w, info.get(w));
		info.remove(w);
	}
	
	@Override
	public void change() 
	{
		window.pack();
		window.repaint();
	}

	@Override
	public void end() 
	{
		openWindow(new EndWindow());
		
		size = window.getSize();
		
		setSize(window, size);
		
		change();
	}
	
	public void plusOnePoint()
	{
		++points;
	}
	
	public int getPoints()
	{
		return points;
	}

	public Map<Word, Coordinate> getInfo()
	{
		return info;
	}
	
	public Map<Word, Coordinate> getSelectedWords()
	{
		return selectedWords;
	}

	public Dimension getWindowSize()
	{
		return size;
	}
	
	private void openWindow(JPanel panel)
	{
		window.getContentPane().removeAll();
		window.setVisible(true);
		
		window.add(panel);
		
		window.pack();
		window.repaint();
	}
}
