package org.github.grashchenko.designePatterns.proxy;

public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String password) {
        if ("Vladimir".equals(user) && "123456".equals(password)) {
            isAdmin = true;
        }
        executor = new ExecutorImpl();
    }

    @Override
    public void runCommand(String command) throws Exception {
        if (!isAdmin) {
            if (command.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            }
        }
        executor.runCommand(command);
    }
}
