package com.justinschaaf.killersnow;

import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class KillerSnow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSnowballHit(ProjectileHitEvent event) {
        if (event.getHitEntity() != null && event.getHitEntity() instanceof Damageable)
            ((Damageable) event.getHitEntity()).damage(getConfig().getDouble("damage"));
    }

}
