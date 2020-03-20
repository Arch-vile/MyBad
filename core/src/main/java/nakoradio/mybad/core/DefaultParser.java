package nakoradio.mybad.core;


import nakoradio.mybad.core.utils.CollectionUtils.List;

// TODO: Add tests
public class DefaultParser implements ErrorParser {

  @Override
  public Failure parse(Exception ex) {
    return Failure.builder()
        .errors(List.of(Error.builder().message(ex.getMessage()).build()))
        .build();
  }

  @Override
  public boolean accepts(Exception ex) {
    return true;
  }
}
