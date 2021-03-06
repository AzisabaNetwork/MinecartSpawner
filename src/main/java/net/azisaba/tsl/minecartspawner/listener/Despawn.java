package net.azisaba.tsl.minecartspawner.listener;

import org.bukkit.Tag;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class Despawn implements Listener {
    @EventHandler
    public void onDismount(EntityDismountEvent event){
        // minecartかボートから降りた時の処理
        if ( event.getDismounted().getType() == EntityType.MINECART ||
            (event.getDismounted().getType() == EntityType.BOAT &&
             Tag.ICE.isTagged(event.getDismounted().getLocation().add(0,-1,0).getBlock().getType()))) {
            // Dismountするときに1つ上の座標にTPする
            event.getEntity().teleport(event.getEntity().getLocation().add(0,1,0));
            event.getDismounted().remove();
        }
    }
}
