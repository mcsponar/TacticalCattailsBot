package command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandRequest {

    public CommandRequest() {
        this.username = "";
        this.message = "";
        this.channel = "";
    }

    public CommandRequest(String username, String message, String channel) {
        this.username = username;
        this.message = message;
        this.channel = channel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    private String username;
    private String message;
    private String channel;


    @Override
    public String toString() {
        return String.format(
                "We received a command from, %s in channel: %s | Full Message was: %s",
                username,
                channel,
                message);
    }

    private String[] splitMessage(){
        List<String> matchList = new ArrayList<>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
        Matcher regexMatcher = regex.matcher(message);
        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        return matchList.toArray(new String[0]);
    }

    public String getCommand() {

        if (splitMessage().length ==0){
            return "";
        }
        else{
             return splitMessage()[0].replaceAll("[.!?,]", "");
        }
    }

    public String getAction (){
        if (splitMessage().length <= 1){
            return "";
        }
        else{
            return splitMessage()[1].replaceAll("[.!?,]", "");
        }
    }

    public String[] getParams(){
        if (splitMessage().length <2){
            return new String[0];
        }
        else{
            String[] split = splitMessage().clone();
            String[] params = new String[split.length - 2];
            for (int i = 2; i < split.length; i++) {
                params[i-2] = split[i].replaceAll("[.!?,\"']", "");
            }
            return params;
        }
    }

}
