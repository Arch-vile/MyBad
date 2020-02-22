package nakoradio.mybad.core;

public interface ErrorParser {
  Error parse(Exception ex);
  boolean accepts(Exception ex);
}
