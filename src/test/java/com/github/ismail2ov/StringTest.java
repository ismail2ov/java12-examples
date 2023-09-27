package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void testStringIndent() {
        final String multilineString = "I am\na multiline\nString.";

        String expected = "    I am\n"
            + "    a multiline\n"
            + "    String.\n";

        String actual = multilineString.indent(4);

        assertThat(actual).isEqualTo(expected);
    }

}
