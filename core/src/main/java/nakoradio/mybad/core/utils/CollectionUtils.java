package nakoradio.mybad.core.utils;

import java.util.Arrays;

public class CollectionUtils {

  public static class List {
    public static <E> java.util.List<E> of(E... elements) {
     return Arrays.asList(elements);
    }
  }


}
