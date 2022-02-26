package game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.Map;

import javax.swing.JFrame;

import constants.GameConstants;
import game_components.*;
import interfaces.IGame;
import parser.Parser;
import windows.*;

public class Game implements IGame
{
	private final LayoutManager LAYOUT = new FlowLayout();
	
	private static Game game = null;
	
	private Map<Word, Coordinate> info = Parser.parse(GameConstants.FILE_PATH); // change name
	private JFrame window;
	
	
	public Game()
	{
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(LAYOUT);
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
		window.add(new MainWindow());
		
		window.pack();
		window.repaint();
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openWordWindow(Word w) 
	{
		window.getContentPane().removeAll();
		
		window.add(new WordWindow(w));
		
		window.pack();
		window.repaint();
	}
	
	public Map<Word, Coordinate> getInfo()
	{
		return info;
	}
}
