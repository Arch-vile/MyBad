package nakoradio.mybad.core;

public interface ErrorParser<T extends Exception> {
  Error parse(T ex);
  boolean accepts(T ex);
}
