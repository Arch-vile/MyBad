package nakoradio.mybad.core;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public class Error {

  // TODO: Consider which are nullable
  @NonNull
  private final ErrorType type;

  private final String message;
  private final String messageCode;
  private final String description;
  private final String technicalDescription;


}

