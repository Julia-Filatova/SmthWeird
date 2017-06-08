package just.smthweird.ui;

import just.smthweird.entities.Coordinates;
import just.smthweird.entities.Field;
import just.smthweird.entities.Lizard;
import just.smthweird.entities.LizardType;

/**
 * Created by filatova on 01.06.17.
 */
public class ConsoleResultDrawer implements ResultDrawer
{
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static final String EMPTY = ANSI_WHITE_BACKGROUND + "-" + ANSI_RESET;

  @Override
  public void printField(Field field, int iteration)
  {
    System.out.println("ITERATION: " + iteration);
    System.out.println("+++++++++++++++++++++++++++++++++++++++++");

    for (int i = 0; i < field.getLength(); i++)
    {
      for (int j = 0; j < field.getWidth(); j++)
      {
        Coordinates coors = new Coordinates(i, j);
        printCell(field.getCell(coors));
      }
      System.out.println();
    }

    System.out.println("+++++++++++++++++++++++++++++++++++++++++");
  }

  private void printCell(Lizard cell)
  {
    if (cell.getType() == LizardType.ALTRUIST)
    {
      System.out.print(ANSI_CYAN_BACKGROUND + cell.getAge() + ANSI_RESET);
    }
    else if (cell.getType() == LizardType.EGOIST)
    {
      System.out.print(ANSI_RED_BACKGROUND + cell.getAge() + ANSI_RESET);
    }
    else
    {
      System.out.print(EMPTY);
    }
  }
}
