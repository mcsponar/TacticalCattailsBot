package command;

import command.pvp.ContentCommandResponse;
import command.pvp.AddContentReplyHandler;

public class CommandRequestHandler {

    private ICommandResponse contentCommandResponse;

    public CommandRequestHandler(ICommandResponse contentCommandResponse) {
        this.contentCommandResponse = contentCommandResponse;
    }

    public void HandleRequest(CommandRequest commandRequest){
        if (commandRequest != null){
            switch (commandRequest.getCommand()){
                case "content":
                    contentCommandResponse.ExecuteCommand(commandRequest);
                    break;
                default:
                    break;

            }
        }

    }
}
