package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.NumberFormat;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class CompactNumberFormattingTest {

    @Test
    void testCompactNumberFormatting() {
        NumberFormat nfShort = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        NumberFormat nfLong = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        assertThat(nfShort.format(1_000)).isEqualTo("1K");
        assertThat(nfShort.format(456_789)).isEqualTo("457K");
        assertThat(nfShort.format(2_000_000)).isEqualTo("2M");
        assertThat(nfShort.format(3_456_789_000L)).isEqualTo("3B");

        assertThat(nfLong.format(1_000)).isEqualTo("1 thousand");
        assertThat(nfLong.format(456_789)).isEqualTo("457 thousand");
        assertThat(nfLong.format(2_000_000)).isEqualTo("2 million");
        assertThat(nfLong.format(3_456_789_000L)).isEqualTo("3 billion");
    }
}
