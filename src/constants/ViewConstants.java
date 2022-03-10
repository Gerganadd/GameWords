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
	public static final String BTN_START_TEXT = "������";
	
	//ExplanationGameWindow
	public static final Dimension D_START_WINDOW = new Dimension(700, 400); 
	public static final Dimension D_START_WINDOW_PNL_BOTTOM = new Dimension(D_START_WINDOW.width, (int) (D_START_WINDOW.height * 0.2));
	public static final Dimension D_START_WINDOW_PNL_TEXT = new Dimension((int) (D_START_WINDOW.getWidth() / 2), D_START_WINDOW.height - D_START_WINDOW_PNL_BOTTOM.height);
	
	public static final String PLAYER_NAME = "������"; 
	public static String PLAYER_WORDS = 
			String.format("�������! �� ��� %s. � ���� ���� �� ����� ���������� �������� ����."
					+ " �� �� ������� ��� �� ��������. �� ������ ����� ��������� ����� � ���."
					+ " ��� ������� ��� � ��, ������� �����."
					+ " ����� �� �� ������?", PLAYER_NAME);
	
	public static String PLAYER_GOODBYE_WORDS = "���������! ��� �� �� �����, ����� ���� �� �� �������.";
	
	public static final String BTN_YES_TEXT = "��";
	public static final String BTN_NO_TEXT = "��";
	public static final String BTN_EXIT_TEXT = "�����";
	
	//MainWindow
	public static final String POINTS_TEXT = "����� : ";
	public static final int POINTS_X = 5;
	public static final int POINTS_Y = 5;
	public static final int POINTS_WIDTH = 50;
	public static final int POINTS_HEIGHT = 30;
	
	//WordWindow
	public static final Color CORRECT_COLOR = Color.GREEN;
	
	public static final String WORD_WINDOW_QUESTION = "��� � ���������� �����? ������ ����� ���.";
	public static final String CORRECT_ANSWEAR = "��������!";
	
	public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2);
	public static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.WHITE, 2);
	public static final Border CORRECT_SELECTED_BORDER = BorderFactory.createLineBorder(CORRECT_COLOR, 2);
	public static final Border WRONG_SELECTED_BORDER = BorderFactory.createLineBorder(Color.RED, 2);
	
	public static final float FONT_SIZE_TEXT = 18.0f;
	public static final float FONT_SIZE_LETTER = 38.0f;
	
	public static final double PROSENTS_OF_WINDOW_PNL_TEXT = 0.1;
	public static final double PROSENTS_OF_WINDOW_PNL_LETTER = 0.13;
	
	public static final String BTN_BACK_TEXT = "�����";
	
	//ResultWindow
	public static String END_TEXT = "����� �������� �: ";
	
	public static final String RESULT_TEXT_10_POINTS = "�����! ������ �� �������!";
	public static final String RESULT_TEXT_9_POINTS = "�����! ����� �� �� ��������!";
	public static final String RESULT_TEXT_8_POINTS = "����� � ��-�����.";
	public static final String RESULT_TEXT_7_POINTS = "�������� ������!";
	public static final String RESULT_TEXT_6_POINTS = "���������� ��!";
	
	
}
