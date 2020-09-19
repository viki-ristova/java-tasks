import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


public class ZipArchiver implements Archiver {
    @Override
    public void archive(File directory, File archive) throws IOException {
        // Create zip file stream.
        try (ZipArchiveOutputStream archiveZip = new ZipArchiveOutputStream(new FileOutputStream(archive.getAbsolutePath()))) {
            // Walk through file structure of the given directory
            Files.walk(directory.toPath()).forEach(p -> {
                File file = p.toFile();
                // the files are streamed into the zip file
                if (!file.isDirectory()) {
                    System.out.println("Creating zip archive for file - " + file);
                    ZipArchiveEntry entry_1 = new ZipArchiveEntry(file, file.toString());
                    try (FileInputStream fis = new FileInputStream(file)) {
                        archiveZip.putArchiveEntry(entry_1);
                        IOUtils.copy(fis, archiveZip);
                        archiveZip.closeArchiveEntry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            archiveZip.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}