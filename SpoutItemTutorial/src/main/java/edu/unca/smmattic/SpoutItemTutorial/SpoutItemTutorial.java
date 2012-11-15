package edu.unca.smmattic.SpoutItemTutorial;

import java.util.logging.Level;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

/*
 * This is the main class of the sample plug-in
 */
public class SpoutItemTutorial extends JavaPlugin {
	public TestItem Bouquet;
	public SpoutItemTutorialCommandExecutor executor;

	/*
	 * This is called when your plug-in is enabled
	 */
	@Override
	public void onEnable() {

		// from Spout tutorial
		//changed this to be a bouquet, not a quaffle
		SpoutManager.getFileManager().addToPreLoginCache(this,
				"http://i1125.photobucket.com/albums/l596/MissParanoidFighter/bouquet.png");
		Bouquet = new TestItem(this, "Bouquet",
				"http://i1125.photobucket.com/albums/l596/MissParanoidFighter/bouquet.png");
		addBouquetRecipe();

		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Enabled!");

		// save the configuration file
		saveDefaultConfig();

		// Create the SampleListener
		new SpoutItemTutorialListener(this);

		// set the command executor for sample
		executor = new SpoutItemTutorialCommandExecutor(this);
		this.getCommand("message").setExecutor(executor);
		this.getCommand("changeMe").setExecutor(executor);
		this.getCommand("changeMeBack").setExecutor(executor);
		//this will turn the player into a cookie like texture
		this.getCommand("cookiePlease").setExecutor(executor);
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Disabled");
	}

	//this is my bouquet recipe. it is six flowers on the top two rows, paper underneath
	public void addBouquetRecipe() {
		SpoutItemStack item = new SpoutItemStack(Bouquet, 1);
		SpoutShapedRecipe recipe = new SpoutShapedRecipe(item);
		recipe.shape("RRR", "RRR", "PPP");// top : middle : bottom
		recipe.setIngredient('R', MaterialData.rose);
		recipe.setIngredient('P', MaterialData.paper);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
	}

}
