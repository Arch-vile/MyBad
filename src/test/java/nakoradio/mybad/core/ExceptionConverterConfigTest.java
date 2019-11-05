package nakoradio.mybad.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionConverterConfigTest {

  @Test
  public void addingNullParser_shouldFail() {
    // When: Adding null parser
    // Then: Will fail
    NullPointerException thrown = assertThrows(NullPointerException.class,
        () -> new ExceptionConverterConfig().addParser(null));

    assertThat(thrown.getMessage(), equalTo("Tried to add null parser"));

  }

}