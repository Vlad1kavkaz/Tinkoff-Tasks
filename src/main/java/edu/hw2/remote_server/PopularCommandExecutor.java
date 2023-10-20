package edu.hw2.remote_server;

import edu.hw2.remote_server.connection_managers.ConnectionManager;
import edu.hw2.remote_server.connections.Connection;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                attempts++;
                throw new ConnectionException(e);
            } catch (Exception e) {
                throw new RuntimeException("Unexpected exception!");
            }
        }
    }

}
