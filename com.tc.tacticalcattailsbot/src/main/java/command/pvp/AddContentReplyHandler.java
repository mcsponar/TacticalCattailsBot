package command.pvp;

import base.Content;
import command.CommandRequest;
import command.IReplyHandler;

public class AddContentReplyHandler implements IReplyHandler {

    @Override
    public void HandleReply(CommandRequest commandRequest) {

        String[] params = commandRequest.getParams().clone();
        System.out.println(
                new Content(
                        params[0],
                        params[1],
                        Integer.parseInt(params[2])).toString());

    }
}
