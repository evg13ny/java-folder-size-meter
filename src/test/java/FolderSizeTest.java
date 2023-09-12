import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FolderSizeTest {
    @Test
    void testGetHumanReadableFolderSize() {
        assertEquals("73,08 kb", FolderSize.getHumanReadableSize(FolderSize.getFolderSize(new File("data/test1"))));
    }

    @Test
    void testGetHumanReadableFileSize() {
        assertEquals("6,53 kb", FolderSize.getHumanReadableSize(FolderSize.getFolderSize(new File("data/test1/test1.txt"))));
    }

    @Test
    void testGetExceptionFolderSize() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> FolderSize.getFolderSize(new File("")));

        String expectedMessage = "Path Error :(";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
