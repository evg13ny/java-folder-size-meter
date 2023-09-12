import java.io.File;
import java.text.DecimalFormat;

public class FolderSize {
    protected static long getFolderSize(File folder) {
        if (!folder.exists()) {
            throw new ArrayIndexOutOfBoundsException("Path Error :(");
        }

        if (folder.isFile()) {
            return folder.length();
        }

        long size = 0;
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += getFolderSize(file);
                }
            }
        }

        return size;
    }

    protected static String getHumanReadableSize(long size) {
        String[] units = new String[]{"b", "kb", "Mb", "Gb"};
        int unitIndex = (int) (Math.log10(size) / 3);
        double unitValue = 1 << (unitIndex * 10);

        return new DecimalFormat("#,##0.##")
                .format(size / unitValue) + " "
                + units[unitIndex];
    }
}
