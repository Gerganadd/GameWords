package constants;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

public class ExplanationGameWindowConstants 
{
	//paths
	public static final String GAME_TITLE_PICTURE_PATH = "src/resources/titleWindow.png";
	
	//view
	public static final LayoutManager PNL_BUTTON_LAYOUT = new FlowLayout(FlowLayout.CENTER);
	public static final LayoutManager PNL_WORDS_LAYOUT = new FlowLayout(FlowLayout.LEFT);
	
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
}
