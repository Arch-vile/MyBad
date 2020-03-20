package nakoradio.mybad.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Result {

  @NonNull
  private final Failure error;

 @NonNull
  private final Exception sourceException;
}
