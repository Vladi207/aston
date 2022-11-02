package org.github.grashchenko.designePatterns.proxy;

public class App {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutorProxy("Vladimir", "1234");
        try
        {
            commandExecutor.runCommand("DIR C:\\WINDOWS\\*.dll");
            commandExecutor.runCommand("rm -rf abc.pdf");
        }
        catch (Exception e) {
            System.out.println("Exception Message: " + e.getMessage());
        }
    }
}
