package org.github.grashchenko.designePatterns.proxy;

public interface CommandExecutor {
    void runCommand(String command) throws Exception;
}
