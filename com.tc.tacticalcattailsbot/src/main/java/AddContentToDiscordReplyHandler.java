import base.Content;
import command.CommandRequest;
import command.IReplyHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class AddContentToDiscordReplyHandler implements IReplyHandler {

    private Content content;
    private JDA api;

    public AddContentToDiscordReplyHandler(JDA api, Content content) {
        this.api = api;
        this.content = content;
    }

    @Override
    public void HandleReply(CommandRequest commandRequest) {

        String[] params = commandRequest.getParams().clone();
        content.setLocation(params[0]);
        content.setDirection(params[1]);
        content.setDistance(Integer.parseInt(params[2]));
        TextChannel textChannel = api.getTextChannelsByName(commandRequest.getChannel(), true).get(0);
        textChannel.sendMessage(String.format("@here *NEW CONTENT ADDED* %s", content)).queue();
    }
}

