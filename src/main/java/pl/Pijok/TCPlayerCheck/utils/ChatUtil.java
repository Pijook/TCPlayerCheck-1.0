package pl.Pijok.TCPlayerCheck.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {

    public static void sendMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String fixColor(String meesage){
        meesage = ChatColor.translateAlternateColorCodes('&', meesage);
        return meesage;
    }
}
