package features;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class FeatureTemplate extends Feature{
	boolean usePrefix = true;
	String command="feature";
	String helpDsc="feature dsc";
	String inDepthDsc="this is a template feature that should not be used";
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if(event.getMessage().getContentStripped().toLowerCase().startsWith((usePrefix?"hi ":"")+command)) {
			String args = event.getMessage().getContentStripped().substring(command.length()+1+(usePrefix?3:0));
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
