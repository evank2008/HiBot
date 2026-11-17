package features;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MoneyFeature extends Feature{
	boolean usePrefix = true;
String command="money";
	String helpDsc="get money once a day";
	String inDepthDsc="Use to earn 1 money. Also checks your balance. \nWill be put on a daily cooldown in the future. \nBalance is listed in binary number format.";

	MoneyTracker mt;
	//money will be stored via roles
	//with binary
	//and backwards
	//"Hiiii" = 00001
	//maximum money of 31
	public MoneyFeature() {
		mt = new MoneyTracker();
	}
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if(event.getMessage().getContentStripped().toLowerCase().startsWith((usePrefix?"hi ":"")+command)) {
        	String args = event.getMessage().getContentStripped().substring(command.length()+(usePrefix?3:0));
        	if(!args.isEmpty()) args=args.substring(1);
        	//if(args.equals("29")) mt.earn(event,29);
        	//else 
        		mt.earn(event,1);
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
