package command;

import junit.framework.TestCase;

public class CommandRequestTest extends TestCase {

    CommandRequest commandRequest;
    String username;
    String message;
    String channel;

    public void setUp() throws Exception {
        super.setUp();
        username = "test";
        message = "!Content add the quick brown fox jumps over the lazy dog";
        channel = "General";

        commandRequest = new CommandRequest(username, message, channel);
    }

    public void tearDown() {
    }

    public void testGetUsername() {
        assertEquals(username, commandRequest.getUsername());
    }

    public void testSetUsername() {
        String expected = "TestTest";
        commandRequest.setUsername(expected);
        assertEquals(expected, commandRequest.getUsername());

    }

    public void testGetMessage() {
        assertEquals(message, commandRequest.getMessage());
    }

    public void testSetMessage() {
        String expected = "!Test test";
        commandRequest.setMessage(expected);
        assertEquals(expected, commandRequest.getMessage());
    }

    public void testGetChannel() {
        assertEquals(channel, commandRequest.getChannel());
    }

    public void testSetChannel() {
        String expected =  "test";
        commandRequest.setChannel(expected);
        assertEquals(expected, commandRequest.getChannel());
    }

    public void testGetCommand() {
        String expected = "Content";
        assertEquals(expected, commandRequest.getCommand());
    }

    public void testGetAction() {
        String expected = "add";
        assertEquals(expected, commandRequest.getAction());
    }

    public void testGetParams() {
        int expected = 9;
        for (String param : commandRequest.getParams()){
            System.out.println(param);
        }
        assertEquals(expected, commandRequest.getParams().length);

    }

    public void testNoParams() {
        String message = "test test";
        int expected = 0;
        commandRequest.setMessage(message);
        assertEquals(expected, commandRequest.getParams().length);
    }

    public void testConcatParams(){
        message = "!Content add \"the quick brown fox\" \"jumps over the lazy dog\"";
        int expected = 2;
        commandRequest.setMessage(message);
        for (String param : commandRequest.getParams()){
            System.out.println(param);
        }
        assertEquals(expected, commandRequest.getParams().length);

    }

    public void testConcatParams2(){
        message = "!Content add \"the quick brown fox\" \"jumps over the lazy\" dog";
        int expected = 3;
        commandRequest.setMessage(message);
        for (String param : commandRequest.getParams()){
            System.out.println(param);
        }
        assertEquals(expected, commandRequest.getParams().length);

    }
}