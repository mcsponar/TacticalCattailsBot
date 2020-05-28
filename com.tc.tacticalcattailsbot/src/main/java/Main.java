import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {


    public static void main(String[] args)
            throws LoginException
    {
        if (args.length < 1) return;
        String token = args[0];
        JDA api = JDABuilder.createDefault(token).build();




    }
}
