package nakoradio.mybad.core;

// TODO: Add tests
public class DefaultParser implements ErrorParser {

  @Override
  public Error parse(Exception ex) {
    return Error.builder()
        .message(ex.getMessage())
        .build();
  }

  @Override
  public boolean accepts(Exception ex) {
    return true;
  }
}
