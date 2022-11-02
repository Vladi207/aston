package org.github.grashchenko.designePatterns.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CommandExecutorProxyTest {

    protected CommandExecutorProxy executorProxyUser;
    protected CommandExecutorProxy executorProxyAdmin;
    protected ByteArrayOutputStream output;

    @Before
    public void setUp() throws Exception {
        executorProxyUser = new CommandExecutorProxy("Vladimir", "12345");
        executorProxyAdmin = new CommandExecutorProxy("Vladimir", "123456");
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void throwsExceptionTest() {
        assertThrows(Exception.class, () -> executorProxyUser.runCommand("rm"));
    }


    @Test
    public void runCommandTest() throws Exception {
        String template = "DIR C:\\WINDOWS\\*.dll - command executed.";
        executorProxyUser.runCommand("DIR C:\\WINDOWS\\*.dll");
        assertEquals(output.toString().replaceAll("\n", "").replaceAll("\r", ""), template);
        output.reset();
        String template1 = "rm -rf abc.pdf - command executed.";
        executorProxyAdmin.runCommand("rm -rf abc.pdf");
        assertEquals(output.toString().replaceAll("\n", "").replaceAll("\r", ""), template1);
    }
}