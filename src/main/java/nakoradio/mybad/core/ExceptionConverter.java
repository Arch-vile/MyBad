package nakoradio.mybad.core;

import java.util.List;

public class ExceptionConverter {

  private final List<ErrorParser> parsers;
  private final ErrorParser defaultParser;

  public ExceptionConverter(ExceptionConverterConfig config) {
    this.parsers = config.getParsers();
   this.defaultParser = new DefaultParser();
  }

  public Error convert(Exception e) {
return    parsers.stream()
    .filter(it -> it.accepts(e))
    .findFirst()
    .orElse(this.defaultParser)
    .parse(e);
  }
}
