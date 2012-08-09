//Made by: Hawkfalcon1. Feel free to use the code
package com.hawkfalcon1.MelonSeedsFromGrass;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MelonSeedsFromGrass extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)

	public void onBlockBreak(BlockBreakEvent event)
	{
		if(event.getBlock().getType() == Material.LONG_GRASS)
		{			
			Block block = event.getBlock();
			Player player = event.getPlayer();
			Random rand = new Random();

			if (rand.nextInt(100) < 5) {
				if (player.hasPermission("MelonSeedsFromGrass.use")) {
					block.setType(Material.AIR);

					block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SEEDS, 1));
					event.setCancelled(true); // Cancel the event because you've done it yourself.
				}
		}
		}
	}
}




