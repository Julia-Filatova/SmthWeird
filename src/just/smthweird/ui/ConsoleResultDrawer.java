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
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static final String ALTRUIST = ANSI_CYAN_BACKGROUND + "A" + ANSI_RESET;
  public static final String EGOIST = ANSI_RED_BACKGROUND + "E" + ANSI_RESET;
  public static final String EMPTY = ANSI_WHITE_BACKGROUND + "-" + ANSI_RESET;

  @Override
  public void printField(Field field, int iteration)
  {
    System.out.println("ITERATION: " + iteration);
    System.out.println("+++++++++++++++++++++++++++++++++++++++++");

    for (int i = 0; i < field.getLength(); i++) {
      for (int j = 0; j < field.getWidth(); j++) {
        Coordinates coors = new Coordinates(i, j);
        printCell(field.getCell(coors));
      }
      System.out.println();
    }

    System.out.println("+++++++++++++++++++++++++++++++++++++++++");
  }

  private void printCell(Lizard cell)
  {
    if (cell.getType() == LizardType.ALTRUIST) {
      System.out.print( ANSI_CYAN_BACKGROUND + cell.getAge() + ANSI_RESET);
    } else if (cell.getType() == LizardType.EGOIST) {
      System.out.print(ANSI_RED_BACKGROUND + cell.getAge() + ANSI_RESET);
    } else {
      System.out.print(EMPTY);
    }
  }
}
