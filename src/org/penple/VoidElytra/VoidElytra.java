package org.penple.VoidElytra;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class VoidElytra extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for (Player player : getServer().getOnlinePlayers()) {
					if (player.isSneaking() && player.isGliding() && player.hasPermission("voidelytra.boost")) {
						player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 0);
						player.setVelocity(player.getLocation().getDirection().add(player.getVelocity()));
					}
				}
			}
		}, 3L, 3L);
	}
}
