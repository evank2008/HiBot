package features;

import java.io.File;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;

public class RevealFeature extends Feature{
	boolean usePrefix = true;
String command="reveal";
	String helpDsc="reveal the hi";
	String inDepthDsc="the rot consumes";

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if(event.getMessage().getContentStripped().toLowerCase().startsWith((usePrefix?"hi ":"")+command)) {
        			event.getChannel().sendFiles(FileUpload.fromData(new File("src/features/hi.jpg"))).queue();
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
