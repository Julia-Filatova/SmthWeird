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
  
  private Field field = Field.FIELD;

  public void randomize()
  {
    for (int i = 0; i < field.getWidth() + field.getLength(); i++)
    {
      generateLizard(field, LizardType.ALTRUIST, random.nextInt(Lizard.MAX_AGE));
    }

    //singe mutated lizard
    generateNewbornLizard(field, LizardType.EGOIST);
  }

  private void generateNewbornLizard(Field field, LizardType lizardType)
  {
    generateLizard(field, lizardType, 0);
  }

  private void generateLizard(Field field, LizardType lizardType, int age)
  {
    int x = random.nextInt(field.getLength());
    int y = random.nextInt(field.getWidth());

    Lizard lizard = Lizard.createLizard(lizardType);
    lizard.setAge(age);

    field.setCell(new Coordinates(x, y), lizard);
  }
}
