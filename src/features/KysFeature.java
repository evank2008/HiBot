package features;

import main.ControlPanel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class KysFeature extends Feature{
	boolean usePrefix = true;
String command="kys";
	String helpDsc="drive hi to suicide. authorization required for use";
	String inDepthDsc="Shuts down the bot. Requires a 'hi killer' role.";

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String messageContent = event.getMessage().getContentRaw().toLowerCase();
         	if(event.getMessage().getContentStripped().toLowerCase().startsWith((usePrefix?"hi ":"")+command)) {
        event.getMember().getRoles().forEach(r->{if(r.getName().equals("hi killer")) {
        	System.out.println("hi killer");
                 event.getChannel().sendMessage("bye").queue();
                 ControlPanel.quitButton.doClick();
                 return;
        }});
        //contains hi and kys but no role detected
        event.getMessage().reply("no").queue();
         	}
        }

	@Override
	public String getCommand() {
		return command;
	}

	@Override
	public String getHelpDsc() {
		return helpDsc;
	}
	@Override
	public String getInDepthDsc() {
		return inDepthDsc;
	}

}
