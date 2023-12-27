package edu.hw6.task6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Task6Test {

    @Test
    void testPortsFileNotNull() {
        List<String> outputLines = new ArrayList<>();

        for (int port = 0; port <= 49151; port++) {
            if (PortScanner.isTcpPortBusy(port)) {
                outputLines.add(toPrettyPrint("TCP", port));
            }

            if (PortScanner.isUdpPortBusy(port)) {
                outputLines.add(toPrettyPrint("UDP", port));
            }
        }

        try {
            Path currentDirectory = Paths.get("src/test/java/edu/hw6/task6").toAbsolutePath();
            Path filePath = currentDirectory.resolve("ports.txt");
            Files.write(filePath, outputLines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            assertFalse(Files.readAllLines(filePath).isEmpty());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String toPrettyPrint(String type, int port) {
        return type + "     " + port + "    " + PortScanner.getServiceName(port);
    }
}


