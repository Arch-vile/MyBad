package nakoradio.mybad.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import nakoradio.mybad.core.utils.CollectionUtils.List;
import org.junit.jupiter.api.Test;

class ExceptionConverterTest {

  @Test
  public void parserApplied() {
    // Given: Config with one parser
    ExceptionConverterConfig config =
        new ExceptionConverterConfig().addParser(new IllegalArgumentExceptionParser());
    ExceptionConverter converter = new ExceptionConverter(config);

    // When: Exception is parsed
    Failure error = converter
        .convert(new IllegalArgumentException("this is the message")).getError();

    // Then: Message is properly parsed
    assertThat(error.getErrors().get(0).getMessage(), equalTo("default This happened: this is the message"));
  }

  @Test
  public void defaultParser() {
    // Given: Config with one parser
    ExceptionConverterConfig config =
        new ExceptionConverterConfig().addParser(new IllegalArgumentExceptionParser());
    ExceptionConverter converter = new ExceptionConverter(config);

    // When: Exception not accepted by any parser is parsed
    Failure error = converter
        .convert(new NullPointerException("this is the message")).getError();

    // Then: Default parser is there to provide the message
    assertThat(error.getErrors().get(0).getMessage(), equalTo("this is the message"));
  }

  @Test
  public void parsersAppliedInOrder() {
    // Given: Config with two parsers accepting the same exceptions
    ExceptionConverterConfig config =
        new ExceptionConverterConfig()
            .addParser(new IllegalArgumentExceptionParser("first"))
            .addParser(new IllegalArgumentExceptionParser("second"));
    ExceptionConverter converter = new ExceptionConverter(config);

    // When: Exception accepted by both parsers is parsed
    Failure error = converter
        .convert(new IllegalArgumentException("this is the message")).getError();

    // Then: First parser is applied
    assertThat(error.getErrors().get(0).getMessage(), equalTo("first This happened: this is the message"));
  }

  @Test
  public void originalExceptionIsAttachedToError() {
    // Given: Config with one parser
    ExceptionConverterConfig config =
        new ExceptionConverterConfig().addParser(new IllegalArgumentExceptionParser());
    ExceptionConverter converter = new ExceptionConverter(config);

    // When: Exception handled by the parser
    IllegalArgumentException ex = new IllegalArgumentException(
        "this is the message");
    Result result = converter.convert(ex);

    // Then: Original exception is available
    assertThat(result.getSourceException(), equalTo(ex));
  }

  public static class IllegalArgumentExceptionParser implements ErrorParser {

    private final String name;

    public IllegalArgumentExceptionParser() {
      this.name = "default";
    }

    public IllegalArgumentExceptionParser(String name) {
      this.name = name;
    }

    @Override
    public Failure parse(Exception ex) {
      return Failure.builder()
          .errors(List.of(Error.builder().message(name + " This happened: " + ex.getMessage()).build()))
          .build();
    }

    @Override
    public boolean accepts(Exception ex) {
      return ex instanceof IllegalArgumentException;
    }
  }

}