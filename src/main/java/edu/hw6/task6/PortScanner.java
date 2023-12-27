package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Map;

public final class PortScanner {
    private PortScanner() {
    }

    private static final Map<Integer, String> POSSIBLE_SERVICES = Map.of(
        135, "EPMAP",
        137, "NETBIOS",
        139, "NETBIOS-SSN",
        445, "MICROSOFT-DS",
        5432, "PostgreSQL",
        27036, "Steam Downloads (Unofficial)"
    );

    public static boolean isTcpPortBusy(final int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    public static boolean isUdpPortBusy(final int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            return false;
        } catch (SocketException e) {
            return true;
        }
    }

    public static String getServiceName(final int port) {
        return POSSIBLE_SERVICES.getOrDefault(port, "Unknown Service");
    }
}
