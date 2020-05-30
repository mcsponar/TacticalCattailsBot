import base.Content;
import base.CraftingMaterial;
import base.Material;
import base.Recipe;
import command.CommandRequest;
import command.CommandRequestHandler;
import command.pvp.ContentCommandResponse;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends ListenerAdapter {

    private static CommandRequestHandler commandRequestHandler;
    private static Content content;

    public static void main(String[] args)
            throws LoginException
    {
        if (args.length < 1) return;
        String token = args[0];
        JDA api = JDABuilder.createDefault(token).build(); //Uncomment to test authentication to server
        content = new Content();
        commandRequestHandler = new CommandRequestHandler(
                new ContentCommandResponse(
                        new AddContentToDiscordReplyHandler(
                                api,
                                content),
                        new PrintContentToDiscordReplyHandler(
                                api,
                                content)));

        api.addEventListener(new Main());
    }


    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return; //escape

        if (!event.getMessage().getContentRaw().startsWith("!")) return; //escape



        CommandRequest commandRequest = new CommandRequest(
                event.getAuthor().getName(),
                event.getMessage().getContentDisplay(),
                event.getChannel().getName());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");


        System.out.printf("%s | Used Command: %s in channel: %s @ %s \n",
                commandRequest.getUsername(),
                commandRequest.getCommand(),
                commandRequest.getChannel(),
                dateTimeFormatter.format(LocalDateTime.now())
        );


        commandRequestHandler.HandleRequest(commandRequest);



//        if(event.getMessage().getContentRaw().equals("!craft")){
//            Material fiber = new Material("Fiber", "https://lastoasis.gamepedia.com/Fiber");
//            Material wood = new Material("Wood", "https://lastoasis.gamepedia.com/Wood");
//            Material woodShaft = new Material("Wood Shaft", "https://lastoasis.gamepedia.com/Wood_Shaft");
//
//            Recipe woodShaftRecipe = new Recipe("Wood Shaft Recipe", woodShaft);
//
//            woodShaftRecipe.Add(new CraftingMaterial(fiber, 2));
//            woodShaftRecipe.Add(new CraftingMaterial(wood, 5));
//
//            event.getChannel().sendMessage(woodShaftRecipe.toString()).queue();
//        }

    }
}
