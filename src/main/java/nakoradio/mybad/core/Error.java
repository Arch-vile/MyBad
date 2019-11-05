package nakoradio.mybad.core;

import java.util.List;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Error extends ErrorDetail {

 // todo add the original error
  private final List<ErrorDetail> causes;
}
