package constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class ViewConstants 
{
	public static final int FONT = Font.PLAIN;
	public static final LayoutManager LAYOUT = new FlowLayout();
	
	public static final Dimension D_WORD_WINDOW = new Dimension(300, 400);
	
	//WordWindow
	public static final Color CORRECT_COLOR = Color.GREEN;
	
	public static final String WORD_WINDOW_QUESTION = "Коя е сгрешената буква? Кликни върху нея.";
	public static final String CORRECT_ANSWEAR = "Правилно!";
	
	public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2);
	public static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.BLUE, 2);
	public static final Border CORRECT_SELECTED_BORDER = BorderFactory.createLineBorder(CORRECT_COLOR, 2);
	public static final Border WRONG_SELECTED_BORDER = BorderFactory.createLineBorder(Color.RED, 2);
	
	public static final float FONT_SIZE_TEXT = 18.0f;
	public static final float FONT_SIZE_LETTER = 38.0f;
	
	public static final double PROSENTS_OF_WINDOW_PNL_TEXT = 0.1;
	public static final double PROSENTS_OF_WINDOW_PNL_LETTER = 0.2;
	
	
	//
	public static final String CONGRATULATION_TEXT = "Поздравления, ти отвори всички сандъци!";
	public static String END_TEXT = "Твоят резултат е: ";
	
	public static final String RESULT_TEXT_10_POINTS = "Браво! Справи се отлично!";
	public static final String RESULT_TEXT_9_POINTS = "Браво! Малко не ти достигна!";
	public static final String RESULT_TEXT_8_POINTS = "Можеш и по-добре.";
	public static final String RESULT_TEXT_7_POINTS = "Внимавай повече!";
	public static final String RESULT_TEXT_6_POINTS = "Упражнявай се!";
	
	
}
