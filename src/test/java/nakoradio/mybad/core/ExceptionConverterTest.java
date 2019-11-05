package nakoradio.mybad.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class ExceptionConverterTest {

  @Test
  public void parserApplied() {
    // Given: Config with one parser
    ExceptionConverterConfig config =
        new ExceptionConverterConfig().addParser(new IllegalArgumentExceptionParser());
    ExceptionConverter converter = new ExceptionConverter(config);

    // Then: Message is parsed
    Error error = converter
        .convert(new IllegalArgumentException("this is the message"));
    assertThat(error.getMessage(), equalTo("this is the message"));
  }

  public static class IllegalArgumentExceptionParser implements ErrorParser<IllegalArgumentException> {

    @Override
    public Error parse(IllegalArgumentException ex) {
      return Error.builder()
          .message(ex.getMessage())
          .build();
    }

    @Override
    public boolean accepts(IllegalArgumentException ex) {
      return true;
    }
  }

}