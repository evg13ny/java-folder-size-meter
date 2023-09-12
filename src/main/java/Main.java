import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Please enter a folder or file path and press <Enter>:");
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();

                if (path.equals("0")) {
                    scanner.close();
                    System.out.println("Bye");
                    System.exit(0);
                }

                long size = FolderSize.getFolderSize(new File(path));
                System.out.println("Folder or file size is: " + FolderSize.getHumanReadableSize(size));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
