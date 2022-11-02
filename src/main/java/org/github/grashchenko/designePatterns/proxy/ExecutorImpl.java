package org.github.grashchenko.designePatterns.proxy;

public class ExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand(String command) throws Exception {
        Runtime.getRuntime().exec(new String[]{"cmd", command});
        System.out.println(command + " - command executed.");
    }
}
