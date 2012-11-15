package edu.unca.smmattic.SpoutItemTutorial;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public class TestItem extends GenericCustomItem {
	public TestItem(Plugin plugin, String name, String texture) {
		super(plugin, name, texture);
	}
}