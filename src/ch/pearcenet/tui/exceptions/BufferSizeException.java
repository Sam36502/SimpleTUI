package ch.pearcenet.tui.exceptions;

public class BufferSizeException extends Exception
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public BufferSizeException()
  {
    super("That buffer size is too large/small");
  }
}
