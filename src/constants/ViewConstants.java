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
	public static final Color BACKGROUND = new Color(91, 95, 140);
	public static final int FONT = Font.PLAIN;
	public static final LayoutManager LAYOUT = new FlowLayout(FlowLayout.CENTER, 0, 0);
	
	//TitleWindow
	public static final String BTN_START_TEXT = "Напред";
	
	//ExplanationGameWindow
	public static final Dimension D_START_WINDOW = new Dimension(700, 400); 
	public static final Dimension D_START_WINDOW_PNL_BOTTOM = new Dimension(D_START_WINDOW.width, (int) (D_START_WINDOW.height * 0.2));
	public static final Dimension D_START_WINDOW_PNL_TEXT = new Dimension((int) (D_START_WINDOW.getWidth() / 2), D_START_WINDOW.height - D_START_WINDOW_PNL_BOTTOM.height);
	
	public static final String PLAYER_NAME = "Наташа"; 
	public static String PLAYER_WORDS = 
			String.format("Здравей! Аз съм %s. В тази игра ще видиш неправилно написани думи."
					+ " Аз ще избирам коя да поправиш. Ти кликни върху грешената буква в нея."
					+ " Ако откриеш коя е тя, печелиш точка."
					+ " Искаш ли да играем?", PLAYER_NAME);
	
	public static String PLAYER_GOODBYE_WORDS = "Довиждане! Ако ти се играе, знаеш къде да ме намериш.";
	
	public static final String BTN_YES_TEXT = "ДА";
	public static final String BTN_NO_TEXT = "НЕ";
	public static final String BTN_EXIT_TEXT = "Изход";
	
	//MainWindow
	public static final String POINTS_TEXT = "Точки : ";
	public static final int POINTS_X = 5;
	public static final int POINTS_Y = 5;
	public static final int POINTS_WIDTH = 50;
	public static final int POINTS_HEIGHT = 30;
	
	//WordWindow
	public static final Color CORRECT_COLOR = Color.GREEN;
	
	public static final String WORD_WINDOW_QUESTION = "Коя е сгрешената буква? Кликни върху нея.";
	public static final String CORRECT_ANSWEAR = "Правилно!";
	
	public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2);
	public static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.WHITE, 2);
	public static final Border CORRECT_SELECTED_BORDER = BorderFactory.createLineBorder(CORRECT_COLOR, 2);
	public static final Border WRONG_SELECTED_BORDER = BorderFactory.createLineBorder(Color.RED, 2);
	
	public static final float FONT_SIZE_TEXT = 18.0f;
	public static final float FONT_SIZE_LETTER = 38.0f;
	
	public static final double PROSENTS_OF_WINDOW_PNL_TEXT = 0.1;
	public static final double PROSENTS_OF_WINDOW_PNL_LETTER = 0.13;
	
	public static final String BTN_BACK_TEXT = "Назад";
	
	//ResultWindow
	public static String END_TEXT = "Твоят резултат е: ";
	
	public static final String RESULT_TEXT_10_POINTS = "Браво! Справи се отлично!";
	public static final String RESULT_TEXT_9_POINTS = "Браво! Малко не ти достигна!";
	public static final String RESULT_TEXT_8_POINTS = "Можеш и по-добре.";
	public static final String RESULT_TEXT_7_POINTS = "Внимавай повече!";
	public static final String RESULT_TEXT_6_POINTS = "Упражнявай се!";
	
	
}
