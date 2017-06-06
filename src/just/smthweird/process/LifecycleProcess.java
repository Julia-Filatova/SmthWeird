package just.smthweird.process;

import java.util.Map.Entry;

import just.smthweird.entities.Coordinates;
import just.smthweird.entities.Empty;
import just.smthweird.entities.Field;
import just.smthweird.entities.Lizard;
import just.smthweird.entities.LizardType;

/**
 * Created by filatova on 01.06.17.
 */
public class LifecycleProcess
{
  public void increaseYear(Field field) {
    field.getAllCells().entrySet().stream()
        .filter(cell -> cell.getValue().getType() != LizardType.EMPTY)
        .forEach(cell -> increaseAge(cell));
  }

  private void increaseAge(Entry<Coordinates, Lizard> cell)
  {
    int newAge = cell.getValue().increaseAge();

    if (newAge > Lizard.MAX_AGE) {
      cell.setValue(Empty.getInstance());
    }
  }

  public void reproduce(Field field) {
    field.getAllCells().entrySet().stream()
        .filter(cell -> cell.getValue().getType() != LizardType.EMPTY)
        .forEach(cell -> findCouple(field, cell));

  }

  private void findCouple(Field field, Entry<Coordinates, Lizard> cell)
  {
    //find all lizards near
    //filter already reproduced
    //random choose one of them
    //if A + E, E reproduces
    //if A + A, random one reproduces
    //if E + E, no one reproduces
  }

  private void spreadChildren(Field field, Entry<Coordinates, Lizard> cell)
  {

  }
}
