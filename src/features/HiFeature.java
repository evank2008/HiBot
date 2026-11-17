package features;

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HiFeature extends Feature{
	boolean usePrefix = false;
	String command="hi";
	String helpDsc="scientists reveal the  hi";
	String inDepthDsc="say hi";

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if(event.getMessage().getContentRaw().equalsIgnoreCase((usePrefix?"hi ":"")+command)) {
        	event.getMessage().reply("hi").queue();
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
