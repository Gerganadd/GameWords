package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import game_components.*;

public class Parser 
{
	public static Map<Word, Coordinate> parse(String path) //to-do: change name
	{
		Map<Word, Coordinate> map = new HashMap<>();
		
		try 
		{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
			doc.getDocumentElement().normalize();
			
			NodeList wordsNList = doc.getElementsByTagName("word");
			
			Element eIndex = (Element) wordsNList.item(0);
			int index = Integer.parseInt(eIndex.getAttribute("indexOfWrongLetter"));
			
			for (int i = 0; i < wordsNList.getLength(); i++)
			{
				Node nCategory = wordsNList.item(i);
				
				if (nCategory.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eCategory = (Element) nCategory;
					
					String wrongWord = eCategory
			                .getElementsByTagName("wrongWord")
			                .item(0)
			                .getTextContent()
			                .trim();
					
					String correctWord = eCategory
							.getElementsByTagName("correctWord")
							.item(0)
							.getTextContent()
							.trim();
					
					String explanation = eCategory
							.getElementsByTagName("explanation")
							.item(0)
							.getTextContent()
							.trim();
					
					Element eCoordinates = (Element) eCategory.getElementsByTagName("coordinates").item(0);
					int x = Integer.parseInt(eCoordinates.getAttribute("x"));
					int y = Integer.parseInt(eCoordinates.getAttribute("y"));
					
					
					map.put(new Word(index, wrongWord, correctWord, explanation), new Coordinate(x, y));
				}
			}
			
		} 
		catch (SAXException | IOException | ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		
		return map;
	}
	
	public static List<Word> parseWords(String path)
	{
		List<Word> words = new ArrayList<>();
		try 
		{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
			doc.getDocumentElement().normalize();
			
			NodeList wordsNList = doc.getElementsByTagName("word");
			
			Element eIndex = (Element) wordsNList.item(0);
			int index = Integer.parseInt(eIndex.getAttribute("indexOfWrongLetter"));
			
			for (int i = 0; i < wordsNList.getLength(); i++)
			{
				Node nCategory = wordsNList.item(i);
				
				if (nCategory.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eCategory = (Element) nCategory;
					
					String wrongWord = eCategory
			                .getElementsByTagName("wrongWord")
			                .item(0)
			                .getTextContent()
			                .trim();
					
					String correctWord = eCategory
							.getElementsByTagName("correctWord")
							.item(0)
							.getTextContent()
							.trim();
					
					String explanation = eCategory
							.getElementsByTagName("explanation")
							.item(0)
							.getTextContent()
							.trim();
					
					words.add(new Word(index, wrongWord, correctWord, explanation));
				}
			}
			
		} 
		catch (SAXException | IOException | ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		
		return words;
	}
	
	public static List<Coordinate> parseCoordinates(String path)
	{
		List<Coordinate> coordinates = new ArrayList<>();
		
		try 
		{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
			doc.getDocumentElement().normalize();
			
			Node nElements = doc.getElementsByTagName("elements").item(0);
			
			if (nElements.getNodeType() == Node.ELEMENT_NODE) 
	        {
	         
				NodeList nListCoordinates = ((Element) nElements).getElementsByTagName("elementCoordinates");
	            
	            
	            for(int i = 0; i < nListCoordinates.getLength(); i++)
	            {
	            	Node node = nListCoordinates.item(i);
	            	
	            	if (node.getNodeType() == Node.ELEMENT_NODE)
	            	{
	            		Element e = (Element) node;
	            		
	            		int x = Integer.parseInt(e.getAttribute("x"));
	            		int y = Integer.parseInt(e.getAttribute("y"));
	            		
	            		coordinates.add(new Coordinate(x, y));
	            		
	            	}
	            }
	        }
		} 
		catch (SAXException | IOException | ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		
		return coordinates;
	}
}
