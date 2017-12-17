package just.smthweird.runner;

import just.smthweird.entities.Field;
import just.smthweird.entities.LizardType;
import just.smthweird.process.DataRandomizer;
import just.smthweird.process.LifecycleProcess;
import just.smthweird.ui.ConsoleResultDrawer;
import just.smthweird.ui.ResultDrawer;

/**
 * Created by filatova on 01.06.17.
 */
public class MainRunner
{
  public static final int TOTAL_YEARS = 50;

  public static void main(String[] args)
  {
    ResultDrawer drawer = new ConsoleResultDrawer();
    LifecycleProcess process = new LifecycleProcess();

    //generate start data (by utility class)
    //start process (cycle)
    //print results
    Field field = Field.initializeField(10, 10);
    new DataRandomizer().randomize();

    drawer.printField(field, 0);

    int i = 0;
    while (field.getAllCells().entrySet().stream()
        .anyMatch(lizardEntry -> lizardEntry.getValue().getType() == LizardType.EGOIST))
    {
      process.increaseYear();

      drawer.printField(field, i++);
    }

  }
}
