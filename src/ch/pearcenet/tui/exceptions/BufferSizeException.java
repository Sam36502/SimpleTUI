package ch.pearcenet.tui.exceptions;

public class BufferSizeException extends Exception
{
  public BufferSizeException()
  {
    super("That buffer size is too large/small");
  }
}
