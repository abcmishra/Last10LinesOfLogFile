import java.util.List;

// Main Class - Entry point for the program
public class LogFileReaderApp {

    public static void main(String[] args) {
        // Provide the path to your log file
        String logFilePath = "path/to/your/logfile.log";

        LogFileService logFileService = new LogFileService(logFilePath);

        // Fetch the last 10 lines of the log file
        List<String> last10Lines = logFileService.fetchLast10Lines();

        // Print the fetched lines
        System.out.println("Last 10 lines of the log file:");
        for (String line : last10Lines) {
            System.out.println(line);
        }
    }
}