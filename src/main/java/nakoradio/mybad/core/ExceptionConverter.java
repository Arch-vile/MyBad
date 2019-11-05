package nakoradio.mybad.core;

import java.util.List;

public class ExceptionConverter {

  private final List<ErrorParser> parsers;

  public ExceptionConverter(ExceptionConverterConfig config) {
    this.parsers = config.getParsers();
  }

  public Error convert(Exception e) {
return    parsers.stream().filter(it -> it.accepts(e)).findFirst().get().parse(e);
  }
}
