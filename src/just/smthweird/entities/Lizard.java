package just.smthweird.entities;

/**
 * Created by filatova on 01.06.17.
 */
public class Lizard
{
  public static int MIN_AGE = 0;

  public static int MIN_REPRODUCTION_AGE = 2;

  public static int MAX_AGE = 5;

  private int age;

  private boolean reproducedThisYear;

  private LizardType type;

  //not sure if I need it
  public static Lizard createLizard(LizardType type) {
    Lizard lizard = new Lizard();

    lizard.type = type;

    return lizard;
  }

  public int getAge()
  {
    return age;
  }

  public int increaseAge()
  {
    return ++age;
  }

  public boolean isMature() {
    return age >= MIN_REPRODUCTION_AGE;
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
