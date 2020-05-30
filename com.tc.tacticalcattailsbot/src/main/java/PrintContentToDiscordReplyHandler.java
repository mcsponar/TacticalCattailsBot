import base.Content;
import command.CommandRequest;
import command.IReplyHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class PrintContentToDiscordReplyHandler implements IReplyHandler {
    private Content content;
    private JDA api;

    public PrintContentToDiscordReplyHandler(JDA api, Content content) {
        this.api = api;
        this.content = content;
    }

    @Override
    public void HandleReply(CommandRequest commandRequest) {

        TextChannel textChannel = api.getTextChannelsByName(commandRequest.getChannel(), true).get(0);
        textChannel.sendMessage(String.format("%s", content)).queue();
    }
}
