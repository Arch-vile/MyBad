package nakoradio.mybad.core;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class Failure {

  private List<Error> errors;
}
