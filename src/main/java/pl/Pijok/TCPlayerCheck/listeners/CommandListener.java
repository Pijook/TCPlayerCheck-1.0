package pl.Pijok.TCPlayerCheck.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.Pijok.TCPlayerCheck.utils.ChatUtil;
import pl.Pijok.TCPlayerCheck.utils.VerifyUtil;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(VerifyUtil.contains(player)){
            if(!event.getMessage().equalsIgnoreCase("/mamcheaty")){
                event.setCancelled(true);
                ChatUtil.sendMessage(player, "&4&lNie mozesz uzywac tej komendy podczas sprawdzania!");
            }
        }
    }
}
