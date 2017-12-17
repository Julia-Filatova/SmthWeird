package just.smthweird.entities;

/**
 * Created by filatova on 01.06.17.
 */
public class Lizard
{

  //TODO move all constants to a properties file

  public static int MIN_REPRODUCTION_AGE = 2;

  public static int MAX_AGE = 9;

  private int age;

  private boolean reproducedThisYear;

  private LizardType type;

  public static Lizard createLizard(LizardType type)
  {
    Lizard lizard = new Lizard();

    lizard.type = type;

    return lizard;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public int increaseAge()
  {
    return ++age;
  }

  public boolean isMature()
  {
    return age >= MIN_REPRODUCTION_AGE;
  }

  public boolean isEmpty()
  {
    return LizardType.EMPTY.equals(getType());
  }

  public boolean isReproducedThisYear()
  {
    return reproducedThisYear;
  }

  public boolean isReproducible()
  {
    return type != LizardType.EMPTY && isMature() && !isReproducedThisYear();
  }

  public void setReproducedThisYear(boolean reproducedThisYear)
  {
    this.reproducedThisYear = reproducedThisYear;
  }

  public LizardType getType()
  {
    return type;
  }
}
