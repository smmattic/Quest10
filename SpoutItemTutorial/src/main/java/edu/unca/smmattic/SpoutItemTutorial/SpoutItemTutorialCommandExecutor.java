package edu.unca.smmattic.SpoutItemTutorial;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spout.player.SpoutCraftPlayer;

import com.google.common.base.Joiner;

public class SpoutItemTutorialCommandExecutor implements CommandExecutor {
	private final SpoutItemTutorial plugin;

	/*
	 * This command executor needs to know about its plugin from which it came
	 * from
	 */
	public SpoutItemTutorialCommandExecutor(SpoutItemTutorial plugin) {
		this.plugin = plugin;
	}

	/*
	 * On command set the sample message
	 */
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.BLUE
					+ "you must be logged on to use these commands");
			return false;

			//this will make people become giant smiley faces
			//because smiley faces are fun
		} else if (command.getName().equalsIgnoreCase("changeMe")
				&& sender.hasPermission("SpoutBlockTutorial.worldBlock")) {
			Player player = (Player) sender;
			SpoutCraftPlayer sp = (SpoutCraftPlayer) player;
			sp.setSkin("http://i1125.photobucket.com/albums/l596/MissParanoidFighter/smile.png");
			return true;

		} else if (command.getName().equalsIgnoreCase("changeMeBack")
				&& sender.hasPermission("SpoutBlockTutorial.worldBlock")) {
			Player player = (Player) sender;
			SpoutCraftPlayer sp = (SpoutCraftPlayer) player;
			sp.resetSkinFor(sp);
			return true;

		} else if (command.getName().equalsIgnoreCase("message")
				&& sender.hasPermission("SpoutBlockTutorial.message")
				&& args.length > 0) {
			this.plugin.getConfig().set("sample.message",
					Joiner.on(' ').join(args));
			return true;
			
			//this is my cookie skin code
		} 	else if (command.getName().equalsIgnoreCase("cookiePlease")
				&& sender.hasPermission("SpoutBlockTutorial.cookiePlease")) {
				Player player = (Player) sender;
				SpoutCraftPlayer sp = (SpoutCraftPlayer) player;
				sp.setSkin("http://i1125.photobucket.com/albums/l596/MissParanoidFighter/cookie.png");
			return true;

		} else {
			return false;
		}
	}

}
