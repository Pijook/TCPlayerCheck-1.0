package pl.Pijok.TCPlayerCheck.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.Pijok.TCPlayerCheck.utils.VerifyUtil;

public class KickListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        if(VerifyUtil.contains(player)){
            VerifyUtil.result(player, "left");
        }
    }
}
