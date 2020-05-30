package command.pvp;

import command.CommandRequest;
import junit.framework.TestCase;

public class ContentCommandResponseTest extends TestCase {

    ContentCommandResponse contentCommandResponse;
    CommandRequest commandRequest;
    String username;
    String message;
    String channel;

    public void setUp() throws Exception {
        super.setUp();
        username = "test";
        message = "!Content add";
        channel = "General";

        contentCommandResponse = new ContentCommandResponse(new AddContentReplyHandler(), null);
        commandRequest = new CommandRequest(username, message, channel);
    }

    public void tearDown() {
    }

    public void testExecuteCommand() {

        contentCommandResponse.ExecuteCommand(commandRequest);

    }
}