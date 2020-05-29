import base.CraftingMaterial;
import base.Material;
import base.Recipe;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {


    public static void main(String[] args)
            throws LoginException
    {
        if (args.length < 1) return;
        String token = args[0];
        JDA api = JDABuilder.createDefault(token).build(); //Uncomment to test authentication to server

        api.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return; //escape

        System.out.println("We received a message from: " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay() + " in channel: " +
                event.getChannel().getName()
        );

        if(event.getMessage().getContentRaw().equals("!craft")){
            Material fiber = new Material("Fiber", "https://lastoasis.gamepedia.com/Fiber");
            Material wood = new Material("Wood", "https://lastoasis.gamepedia.com/Wood");
            Material woodShaft = new Material("Wood Shaft", "https://lastoasis.gamepedia.com/Wood_Shaft");

            Recipe woodShaftRecipe = new Recipe("Wood Shaft Recipe", woodShaft);

            woodShaftRecipe.Add(new CraftingMaterial(fiber, 2));
            woodShaftRecipe.Add(new CraftingMaterial(wood, 5));

            event.getChannel().sendMessage(woodShaftRecipe.toString()).queue();
        }

    }
}
