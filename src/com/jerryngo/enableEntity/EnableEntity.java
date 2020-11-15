package com.jerryngo.enableEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import net.minecraft.server.v1_16_R3.*;

public class EnableEntity extends JavaPlugin{
	@Override
	public void onEnable() {
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, (Runnable)()->{
			int i = 0;
			World w = Bukkit.getWorld("world");
			for(Entity e : w.getEntities()) {
				net.minecraft.server.v1_16_R3.Entity nms = ((CraftEntity)e).getHandle();
				if(nms instanceof EntityInsentient) {
					if(!((EntityInsentient)nms).aware) {
						((EntityInsentient)nms).aware = true;
					}
					getLogger().info("Fix " + i + "th Frozen Mob");
					i += 1;
				}
			}
		}, 40, 1000);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
