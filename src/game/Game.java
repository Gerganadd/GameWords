package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import constants.GameConstants;
import constants.ViewConstants;
import game_components.*;
import interfaces.IGame;
import parser.Parser;
import windows.*;

public class Game implements IGame
{
	private static Game game = null;
	
	private Dimension size;
	
	private Map<Word, Coordinate> info = Parser.parse(GameConstants.FILE_PATH); // change name
	private Map<Word, Coordinate> selectedWords = new HashMap<>();
	private JFrame window;
	
	
	public Game()
	{
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(ViewConstants.BACKGROUND);
		window.setLayout(ViewConstants.LAYOUT);
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
	
	@Override
	public void start()
	{
		window.add(new StartWindow());
		
		window.pack();
		window.repaint();
		
		//size = window.getSize();
		
		window.setVisible(true);
	}
	
	@Override
	public void openGame()
	{
		window.getContentPane().removeAll();
		
		window.add(new MainWindow());
		
		window.pack();
		window.repaint();
		
		size = window.getSize();
		
		window.setVisible(true);
	}

	@Override
	public void end() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change() 
	{
		window.pack();
		window.repaint();
	}
	

	@Override
	public void openWordWindow(Word w) 
	{
		window.getContentPane().removeAll();
		
		window.add(new WordWindow(w));
		
		window.pack();
		window.repaint();
		
		setSize(window, size);
		
		selectedWords.put(w, info.get(w));
		info.remove(w);
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
}
