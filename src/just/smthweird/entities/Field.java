package just.smthweird.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by filatova on 01.06.17.
 */
public enum Field
{
  FIELD;

  private int length;

  private int width;

  public static Field initializeField(int length, int width)
  {
    FIELD.data = new HashMap<>();

    FIELD.length = length;
    FIELD.width = width;

    //initialize cells
    for (int i = 0; i < length; i++)
    {
      for (int j = 0; j < width; j++)
      {
        Coordinates coors = new Coordinates(i, j);
        FIELD.data.put(coors, Empty.getInstance());
      }
    }

    return FIELD;
  }

  private Map<Coordinates, Lizard> data;

  public Map<Coordinates, Lizard> getAllCells()
  {
    return data;
  }

  public Lizard getCell(Coordinates coordinates)
  {
    return data.get(coordinates);
  }

  public void setCell(Coordinates coordinates, Lizard lizard)
  {
    data.put(coordinates, lizard);
  }

  public int getLength()
  {
    return length;
  }

  public int getWidth()
  {
    return width;
  }
}
