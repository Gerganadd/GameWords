package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import game_components.Word;

public class Parser 
{
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
}
