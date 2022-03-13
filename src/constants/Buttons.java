package constants;

public enum Buttons 
{
	BTN_START_TEXT("Напред"),
	BTN_BACK_TEXT("Назад"),
	BTN_YES_TEXT("Да"),
	BTN_NO_TEXT("Не"),
	BTN_EXIT_TEXT("Изход");

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
