package features;

import java.util.HashMap;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MoneyTracker {

	
	//feature list:
	/*
	 * convert number from 0-31 to hi
	 * Hiiii
	 * forwards binary, hIiii = 01000
	 * store a txt file with users and balances
	 * keep in memory
	 */
	public static HashMap<String, UserData> balances = new HashMap<String, UserData>();
	
	public void earn(MessageReceivedEvent event, int amount) {
		String id = event.getAuthor().getId();
		if(balances.containsKey(id)) {
			//check if cooldown is up
			if(isOnCooldown(id)) {
				event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle(event.getMember().getEffectiveName()+" money")
						.setDescription("Balance: "+numToHi(balances.get(id).balance)).setFooter("⏰ Earning is on cooldown until tomorrow").build()).queue();
				return;
			}  
		}	//add 1 if present, if not put 1
			boolean add = addMoney(id, amount);
			if(add) {
			event.getChannel().sendMessage("💸 Money +"+amount+" 💸").queue();
			} else {
			event.getChannel().sendMessage("❌ Can't exceed 31 money, transaction failure ❌").queue();
			}
			event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle(event.getMember().getEffectiveName()+" Money")
					.setDescription("Balance: "+numToHi(balances.get(id).balance)).build()).queue();
			
		}
	public boolean addMoney(String id, int amount) {
		if(balances.getOrDefault(id, new UserData(0)).balance+amount>31) {
			return false;
		}
		balances.put(id, new UserData(balances.getOrDefault(id, new UserData(0)).balance+amount));
		return true;
	}
	
	boolean isOnCooldown(String id) {
		return false; //TODO this
	}
	static String numToHi(int numi) {
		short num = (short)numi;
		StringBuilder sb = new StringBuilder("hiiii");
		for(int i = 0; i<5;i++) {
			short shifted = num;
			shifted<<=11+i;
			shifted>>=15;
			if(shifted!=0) {
				sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
			}
		}
		return sb.toString();
	}
	static short hiToNum(String hi) {
		short num=0;
		for(int i = 4;i>=0;i--) {
			if(Character.isUpperCase(hi.charAt(i))) {
				num+=Math.pow(2, 4-i);
			}
		}
		return num;
	}
	
}
class UserData {
	int balance;
	boolean onCooldown;
	public UserData(int b) {
		balance = b;
		onCooldown=false;
	}
	public UserData(int b, boolean c) {
		balance = b;
		onCooldown=c;
	}
}
