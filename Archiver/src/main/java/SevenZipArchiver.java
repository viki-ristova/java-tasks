import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class SevenZipArchiver implements Archiver {
    @Override
    public void archive(File directory, File archive) throws IOException {
        SevenZOutputFile sevenZFile = new SevenZOutputFile(archive);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.println("Creating 7zip file for file - " + file);
            }
            SevenZArchiveEntry entry = sevenZFile.createArchiveEntry(file, file.getName());
            sevenZFile.putArchiveEntry(entry);
            sevenZFile.write(FileUtils.readFileToByteArray(file));
            sevenZFile.closeArchiveEntry();
        }
        sevenZFile.finish();
    }
}
