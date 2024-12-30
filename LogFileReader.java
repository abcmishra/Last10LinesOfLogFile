import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// LogFileReader Class - Responsible for reading a log file
class LogFileReader {

    private File logFile;

    public LogFileReader(String filePath) {
        this.logFile = new File(filePath);
    }

    /**
     * Reads the last N lines of the log file.
     * @param numLines Number of lines to read from the end.
     * @return List of strings containing the last N lines.
     * @throws IOException If there is an error reading the file.
     */
    public List<String> readLastNLines(int numLines) throws IOException {
        List<String> result = new ArrayList<>();
        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(logFile, "r");
            long fileLength = logFile.length();
            long pointer = fileLength - 1;

            StringBuilder currentLine = new StringBuilder();
            int lineCount = 0;

            // Start reading the file from the end
            while (pointer >= 0) {
                raf.seek(pointer);
                char currentChar = (char) raf.readByte();

                if (currentChar == '\n') {
                    if (currentLine.length() > 0) {
                        result.add(currentLine.reverse().toString());
                        currentLine.setLength(0);
                        lineCount++;

                        if (lineCount == numLines) {
                            break;
                        }
                    }
                } else {
                    currentLine.append(currentChar);
                }
                pointer--;
            }

            // Add the first line if the file doesn't end with a newline
            if (lineCount < numLines && currentLine.length() > 0) {
                result.add(currentLine.reverse().toString());
            }

            Collections.reverse(result);
            return result;
        } finally {
            if (raf != null) {
                raf.close();
            }
        }
    }
}
