package constants;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class WordWindowConstants 
{
	public static final Color CORRECT_COLOR = Color.GREEN;
	
	public static final String WORD_WINDOW_QUESTION = "Коя е сгрешената буква? Кликни върху нея.";
	public static final String CORRECT_ANSWEAR = "Правилно! + 1 точка";
	
	public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2);
	public static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.WHITE, 2);
	public static final Border CORRECT_SELECTED_BORDER = BorderFactory.createLineBorder(CORRECT_COLOR, 2);
	public static final Border WRONG_SELECTED_BORDER = BorderFactory.createLineBorder(Color.RED, 2);
	
	public static final float FONT_SIZE_LETTER = 38.0f;
	
	public static final double PROSENTS_OF_WINDOW_PNL_TEXT = 0.2;
	public static final double PROSENTS_OF_WINDOW_PNL_LETTER = 0.13;
}
