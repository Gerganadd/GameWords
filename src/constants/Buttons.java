package constants;

public enum Buttons 
{
	BTN_START_TEXT("������"),
	BTN_BACK_TEXT("�����"),
	BTN_YES_TEXT("��"),
	BTN_NO_TEXT("��"),
	BTN_EXIT_TEXT("�����");

	private String value;
	
	private Buttons(String value) 
	{
		this.value = value;
	}
	
	public String getText()
	{
		return this.value;
	}
}
