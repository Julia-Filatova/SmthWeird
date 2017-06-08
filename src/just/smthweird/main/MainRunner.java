package just.smthweird.main;

import just.smthweird.entities.Coordinates;
import just.smthweird.entities.Field;
import just.smthweird.entities.Lizard;
import just.smthweird.entities.LizardType;
import just.smthweird.process.LifecycleProcess;
import just.smthweird.ui.ConsoleResultDrawer;
import just.smthweird.ui.ResultDrawer;

/**
 * Created by filatova on 01.06.17.
 */
public class MainRunner
{
  public static int TOTAL_YEARS = 50;

  public static void main(String[] args)
  {
    ResultDrawer drawer = new ConsoleResultDrawer();
    LifecycleProcess process = new LifecycleProcess();

    //generate start data (by utility class)
    //start process (cycle)
    //print results every 2 sec
    Field field = Field.createField(10, 10);
    field.setCell(new Coordinates(2,3), Lizard.createLizard(LizardType.ALTRUIST));
    field.setCell(new Coordinates(2,4), Lizard.createLizard(LizardType.ALTRUIST));
    field.setCell(new Coordinates(3,5), Lizard.createLizard(LizardType.EGOIST));
    field.setCell(new Coordinates(4,5), Lizard.createLizard(LizardType.ALTRUIST));
    field.setCell(new Coordinates(4,8), Lizard.createLizard(LizardType.ALTRUIST));

    drawer.printField(field, 0);
    for (int i = 0; i < TOTAL_YEARS; i++) {
      process.increaseYear();

      drawer.printField(field, i + 1);
    }

  }
}
