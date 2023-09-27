package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class FilesTest {

    @Test
    void testFilesMismatch() throws IOException {
        Path filePath1 = Paths.get("src/test/resources/file1.txt");
        Path filePath2 = Paths.get("src/test/resources/file2.txt");
        Path filePath3 = Paths.get("src/test/resources/file3.txt");

        long mismatch = Files.mismatch(filePath1, filePath2);
        long noMismatch = Files.mismatch(filePath1, filePath3);

        assertThat(noMismatch).isEqualTo(-1L);
        assertThat(mismatch).isEqualTo(102L);
    }
}
