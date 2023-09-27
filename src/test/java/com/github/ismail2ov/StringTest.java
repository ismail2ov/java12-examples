package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
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

    @Test
    void testStringTransform() {
        String uppercase = "abcde".transform(String::toUpperCase);
        Integer i = "12345".transform(Integer::valueOf);
        BigDecimal big = "1234567891011121314151617181920".transform(BigDecimal::new);

        assertThat(uppercase).isEqualTo("abcde".toUpperCase());
        assertThat(i).isEqualTo(Integer.valueOf("12345"));
        assertThat(big).isEqualTo(new BigDecimal("1234567891011121314151617181920"));
    }
}
