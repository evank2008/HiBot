package features;

import java.util.Random;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ByeFeature extends Feature{
	boolean usePrefix = false;
	String command="bye";
	String helpDsc="dont say bye >:(";
	String inDepthDsc="hi will be very upset if you say bye";

	String[] angryEmoji = {
			"<:blast:1414777456975413341>",
			"<:alex:1450370613972832277>"
			,"<:blast:1414777456975413341>"
			,"<:blunder:1415451316829814875>"
			,"<:blunder:1502834128414965900>"
			,"<:disappointment:1546382256430645258>"
			,"<:gosh:1414779349974126684>"
			,"<:house:1414777959411220530>"
			,"<:kidnapping:1442986086816153630>"
			,"<:prayer:1547771911419854859>"
			,"<:wahh:1414775679203016754>"
			,"<:whata:1555758470727344219>"
	};
	Random ran = new Random();
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if(event.getMessage().getContentStripped().toLowerCase().startsWith((usePrefix?"hi ":"")+command)) {
        	
        	String str = angryEmoji[ran.nextInt(angryEmoji.length)];
        	Emoji e = Emoji.fromFormatted(str);
        	
        	
        	
			event.getMessage().addReaction(e).queue();
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
