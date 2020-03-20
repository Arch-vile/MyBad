package nakoradio.mybad.core;

public interface ErrorParser {
  Failure parse(Exception ex);
  boolean accepts(Exception ex);
}
