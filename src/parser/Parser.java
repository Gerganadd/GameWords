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
	public static Map<Word, Coordinate> parse(String path) 
	{
		Map<Word, Coordinate> map = new HashMap<>();
		
		try 
		{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path);
			doc.getDocumentElement().normalize();
			
			NodeList wordsNList = doc.getElementsByTagName("word");
			
			for (int i = 0; i < wordsNList.getLength(); i++)
			{
				Element eIndex = (Element) wordsNList.item(i);
				int index = Integer.parseInt(eIndex.getAttribute("indexOfWrongLetter"));
				
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

}
