import java.io.IOException;

public interface Archiver {
    void archive(java.io.File directory, java.io.File archive) throws IOException;
}
