package nakoradio.mybad.core;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Error extends ErrorDetail {

  private final List<ErrorDetail> causes = new ArrayList<>();
}
