import java.io.IOException;
import java.util.Collections;
import java.util.List;

// LogFileService Class - Higher-level abstraction for handling log files
class LogFileService {

    private LogFileReader logFileReader;

    public LogFileService(String filePath) {
        this.logFileReader = new LogFileReader(filePath);
    }

    /**
     * Fetches the last 10 lines of the log file.
     * @return List of strings containing the last 10 lines.
     */
    public List<String> fetchLast10Lines() {
        try {
            return logFileReader.readLastNLines(10);
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
