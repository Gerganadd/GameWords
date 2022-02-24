package game_components;

public class Word 
{
	private int indexOfWrongLetter;
	private String wrongWord;
	private String correctWord;
	private String explanation;
	
	public Word(int indexOfWrongLetter, String wrongWord, String correctWord, String explanation)
	{
		setIndexOfWrongLetter(indexOfWrongLetter);
		setWrongWord(wrongWord);
		setCorrectWord(correctWord);
		setExplanation(explanation);
	}
	
	private void setIndexOfWrongLetter(int indexOfWrongLetter) 
	{
		if (indexOfWrongLetter >= 0)
		{
			this.indexOfWrongLetter = indexOfWrongLetter;
		}
	}
	
	private void setWrongWord(String wrongWord) 
	{
		if (wrongWord != null && !wrongWord.isEmpty())
		{
			this.wrongWord = wrongWord;
		}
	}
	
	private void setCorrectWord(String correctWord) 
	{
		if (correctWord != null && !correctWord.isEmpty())
		{
			this.correctWord = correctWord;
		}
	}
	
	private void setExplanation(String explanation)
	{
		if (explanation != null && !explanation.isEmpty())
		{
			this.explanation = explanation;
		}
	}
	
	public int getIndexOfWrongLetter() 
	{
		return indexOfWrongLetter;
	}
	
	public String getWrongWord()
	{
		return wrongWord;
	}
	
	public String getCorrectWord()
	{
		return correctWord;
	}
	
	public String getExplanation() 
	{
		return explanation;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s - %s%n%s", getWrongWord(), getCorrectWord(), getExplanation());
	}
	
}
