package tests;

import java.util.List;

import constants.GameConstants;
import game_components.Word;
import parser.Parser;

public class TestParser {

	public static void main(String[] args) {
		List<Word> words = Parser.parseWords(GameConstants.FILE_PATH);
		words.forEach(x -> System.out.println(x));
	}

}
