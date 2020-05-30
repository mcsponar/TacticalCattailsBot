package command.pvp;

import command.CommandRequest;
import junit.framework.TestCase;

public class AddContentReplyHandlerTest extends TestCase {

    CommandRequest commandRequest;
    String username;
    String message;
    String channel;

    AddContentReplyHandler addContentReplyHandler;

    public void setUp() throws Exception {
        super.setUp();
        username = "test";
        message = "!Content add \"Ancient Grassland\" \"NW\" 100";
        channel = "General";

        commandRequest = new CommandRequest(username, message, channel);
        addContentReplyHandler = new AddContentReplyHandler();
    }


    public void testHandleReply() {
        addContentReplyHandler.HandleReply(commandRequest);
    }
}