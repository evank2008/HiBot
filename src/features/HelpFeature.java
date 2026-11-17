package features;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import main.HiBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;

public class HelpFeature extends Feature{
	boolean usePrefix = true;
	String command="help";
	String helpDsc="list commands. use 'hi help [command]' for more";
	String inDepthDsc="Lists out commands and their effects. Use \"hi help [command]\" to see details about a specific command.";

	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String msg = event.getMessage().getContentRaw().toLowerCase();
		if(msg.startsWith((usePrefix?"hi ":"")+command)) {
			
				if(msg.length()>8) {
				for(Feature f: HiBot.features) {
					if(f.getCommand().equalsIgnoreCase(msg.substring(8))) {
						if(msg.substring(8).equals("reveal")) {
							for(int i = 0; i<5; i++) {
								event.getChannel().sendMessage("the rot consumes").queue();
							}
							event.getChannel().sendFiles(FileUpload.fromData(new File("src/features/rot.jpg"))).queue();
							for(int i = 0; i<5; i++) {
								event.getChannel().sendMessage("the rot consumes").queue();
							}
						}
						event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle(f.getCommand()).setDescription(f.getInDepthDsc()).build()).queue();
						
						return;
					}
				}
				}
			
			ArrayList<MessageEmbed> embeds = new ArrayList<MessageEmbed>();
			for(Feature f: HiBot.features) {
				if(f.getHelpDsc()==null) continue;
				embeds.add(new EmbedBuilder().setTitle(f.getCommand()).setDescription(f.getHelpDsc()).setColor(Color.green)
				.build());
			}
			event.getChannel().sendMessageEmbeds(embeds).queue();
		}}
	
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
