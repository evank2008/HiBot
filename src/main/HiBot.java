package main;

import java.util.EnumSet;

import features.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class HiBot {

	public static JDA jda;
	public static Feature[] features = {
			new HiFeature(),
			new HelpFeature(),
			new ByeFeature(),
			new KysFeature(),
			new RevealFeature(),
			new MoneyFeature()
	};
	ControlPanel cp;
	public static final String BOT_TOKEN=System.getenv("HI_BOT_TOKEN");
	public static void main(String[] args) {
		new HiBot();
	}
	public HiBot() {
		jda = JDABuilder.createDefault(BOT_TOKEN).enableIntents(EnumSet.allOf(GatewayIntent.class))
				.build();
		
		cp = new ControlPanel();
		jda.addEventListener(features);
		
	}
}
