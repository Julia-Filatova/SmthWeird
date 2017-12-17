package just.smthweird.process;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
  public static final double CHANCE_OF_ACCIDENT = 0.05;

  public static final Random random = new Random();

  private Field field = Field.FIELD;

  public void increaseYear()
  {
    field.getAllCells().entrySet().stream()
        .filter(cell -> cell.getValue().getType() != LizardType.EMPTY)
        .forEach(cell -> increaseAge(cell));

    reproduce();
  }

  private void increaseAge(Entry<Coordinates, Lizard> cell)
  {
    int newAge = cell.getValue().increaseAge();

    if (newAge > Lizard.MAX_AGE || random.nextDouble() < CHANCE_OF_ACCIDENT)
    {
      cell.setValue(Empty.getInstance());
    }
    else
    {
      cell.getValue().setReproducedThisYear(false);
    }
  }

  public void reproduce()
  {
    field.getAllCells().entrySet().stream()
        .filter(cell -> cell.getValue().getType() == LizardType.EGOIST)
        .forEach(cell -> findCouple(cell));

    field.getAllCells().entrySet().stream()
        .filter(cell -> cell.getValue().getType() == LizardType.ALTRUIST)
        .forEach(cell -> findCouple(cell));

  }

  private void findCouple(Entry<Coordinates, Lizard> cell)
  {
    //find all lizards near
    //filter already reproduced
    //random choose one of them

    findNearCells(cell).stream()
        .filter(lizardEntry -> lizardEntry.getValue().isReproducible())
        .findAny()
        .ifPresent(lizardEntry -> reproduceAndSpread(cell, lizardEntry));
  }

  private void reproduceAndSpread(Entry<Coordinates, Lizard> entry1, Entry<Coordinates, Lizard> entry2)
  {
    LizardType type1 = entry1.getValue().getType();
    LizardType type2 = entry1.getValue().getType();

    //FIXME

    if (type1 == LizardType.EGOIST && type2 == LizardType.EGOIST)
    {
      return;
    }

    if (type1 == LizardType.EGOIST)
    {
      spreadChildren(entry1);
      entry1.getValue().setReproducedThisYear(true);
    }
    else if (type2 == LizardType.EGOIST)
    {
      spreadChildren(entry2);
      entry2.getValue().setReproducedThisYear(true);
    }
    else if (random.nextBoolean())
    {
      spreadChildren(entry1);
      entry1.getValue().setReproducedThisYear(true);
    }
    else
    {
      spreadChildren(entry2);
      entry2.getValue().setReproducedThisYear(true);
    }

    entry1.getValue().setReproducedThisYear(true);
    entry2.getValue().setReproducedThisYear(true);

    //if A + E, E reproduces
    //if A + A, random one reproduces
    //if E + E, no one reproduces
  }

  private void spreadChildren(Entry<Coordinates, Lizard> cell)
  {
    findNearCells(cell).stream()
        .filter(lizardEntry -> lizardEntry.getValue().getType() == LizardType.EMPTY)
        .filter(lizardEntry -> random.nextBoolean())//spread only on part of cells
        .forEach(lizardEntry -> lizardEntry.setValue(Lizard.createLizard(cell.getValue().getType())));
  }

  //need to be refactored
  private List<Entry<Coordinates, Lizard>> findNearCells(Entry<Coordinates, Lizard> cell)
  {
    Set<Coordinates> nearCoordinates = new HashSet<>();

    for (int i = -1; i <= 1; i++)
    {
      for (int j = -1; j <= 1; j++)
      {
        if (i == 0 && j == 0)
        {
          continue;
        }

        nearCoordinates.add(new Coordinates(cell.getKey().getX() + i, cell.getKey().getY() + j));
      }
    }

    return field.getAllCells().entrySet().stream()
        .filter(lizardEntry -> nearCoordinates.contains(lizardEntry.getKey()))
        .collect(Collectors.toList());
  }
}
