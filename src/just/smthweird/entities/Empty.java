package just.smthweird.entities;

/**
 * Created by filatova on 01.06.17.
 * null object
 */
public class Empty extends Lizard
{
  private Empty() {}

  private static Empty instance = new Empty();

  public static Empty getInstance() {
    return instance;
  }

  public int getAge()
  {
    return 0;
  }

  public int increaseAge()
  {
    return 0;
  }

  public boolean isMature()
  {
    return false;
  }

  public boolean isReproducedThisYear()
  {
    return false;
  }

  public void setReproducedThisYear(boolean reproducedThisYear)
  {

  }

  public LizardType getType()
  {
    return LizardType.EMPTY;
  }

  public void setType(LizardType type)
  {

  }
}
