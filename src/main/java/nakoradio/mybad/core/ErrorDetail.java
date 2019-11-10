package nakoradio.mybad.core;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
abstract public class ErrorDetail {

  // TODO: Consider which are nullable
  private final String message;
  private final String messageCode;
  private final String description;
  private final String technicalDescription;


}

