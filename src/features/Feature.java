package features;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Feature extends ListenerAdapter{

	

public abstract String getCommand();
public abstract String getHelpDsc();
public abstract String getInDepthDsc();

@Override
public abstract void onMessageReceived(MessageReceivedEvent event);
}
