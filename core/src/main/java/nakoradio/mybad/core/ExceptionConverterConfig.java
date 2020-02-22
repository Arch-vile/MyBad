package nakoradio.mybad.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class ExceptionConverterConfig {
  private List<ErrorParser> parsers = new ArrayList<>();

  public ExceptionConverterConfig addParser(ErrorParser parser) {
    parsers.add(Objects.requireNonNull(parser, "Tried to add null parser"));
    return this;
  }
}
