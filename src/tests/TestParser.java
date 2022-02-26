package tests;

import java.util.Map;

import constants.GameConstants;
import game_components.Coordinate;
import game_components.Word;
import parser.Parser;

public class TestParser {

	public static void main(String[] args) 
	{
		Map<Word, Coordinate> info = Parser.parse(GameConstants.FILE_PATH);
		info.forEach((k, v) -> System.out.println(k + " : " + v));
	}

}
