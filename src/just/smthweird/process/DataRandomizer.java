package just.smthweird.process;

import java.util.Random;

import just.smthweird.entities.Coordinates;
import just.smthweird.entities.Field;
import just.smthweird.entities.Lizard;
import just.smthweird.entities.LizardType;

/**
 * Created by filatova on 02.06.17.
 */
public class DataRandomizer
{
  public static final Random random = new Random();

  public void randomize(Field field) {
    //dunno
    for (int i = 0; i < field.getWidth() + field.getLength(); i++) {
      int x = random.nextInt(field.getLength());
      int y = random.nextInt(field.getWidth());

      Lizard lizard = Lizard.createLizard(LizardType.ALTRUIST);
      lizard.setAge(random.nextInt(Lizard.MAX_AGE));

      field.setCell(new Coordinates(x, y), lizard);
    }

    int x = random.nextInt(field.getLength());
    int y = random.nextInt(field.getWidth());

    Lizard lizard = Lizard.createLizard(LizardType.EGOIST);

    field.setCell(new Coordinates(x, y), lizard);
  }
}
