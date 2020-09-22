import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        File dir = new File("files");
        System.out.println("Please specify the compression algorithm, for 'zip' choose 1 and press enter, and for '7z' choose 2 and press enter.  ");
        int c = Integer.valueOf(new Scanner(System.in).next());
        if (c == 1) {
            ZipArchiver zipArchiver = new ZipArchiver();
            File arc = new File("archive.zip");
            try {
                zipArchiver.archive(dir, arc);
                System.out.println("Zip archive created successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (c == 2) {
            SevenZipArchiver sevenZipArchiver = new SevenZipArchiver();
            File arc = new File("archive.7z");
            try {
                sevenZipArchiver.archive(dir, arc);
                System.out.println("7zip archive created successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("An error occurred. :/");
        }
    }
}
