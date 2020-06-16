package pl.Pijok.TCPlayerCheck.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VerifyUtil {

    private static ArrayList<Player> to_verify = new ArrayList<Player>();

    public static void add(Player player){
        to_verify.add(player);
    }

    public static void remove(Player player){
        if(to_verify.contains(player)){
            to_verify.remove(player);
        }
    }

    public static boolean contains(Player player){
        if(to_verify.contains(player)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void sendAlert(Player player){

        for(int i = 0; i < 5;i++){
            ChatUtil.sendMessage(player, ChatUtil.fixColor("&4&lJestes sprawdzany. Wejdz na serwer glosowy TS3 ts.mctc.pl"));
        }

        player.sendTitle(ChatColor.RED + "Ostrzezenie", ChatColor.DARK_RED+ "Jestes sprawdzany. Wejdz na serwer glosowy TS3 ts.mctc.pl");

        ChatUtil.sendMessage(player, ChatUtil.fixColor("&c&lUzyj komendy &4/mamcheaty &c&laby sie przyznac"));

    }

    public static void result(Player player, String result){
        //String pl.Pijok.TCPlayerCheck.command = "tempban %player% 7d %result%";
        String command;
        if(result.equalsIgnoreCase("cheater")){
            command = "ban " + player.getName() + " 7d Cheaty";
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
        }
        else if(result.equalsIgnoreCase("left")){
            command = "ban " + player.getName() + " 30d Wyjscie podczas sprawdzania";
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
        }
        else if(result.equalsIgnoreCase("nocoop")){
            command = "ban " + player.getName() + " 14d Brak wspolpracy";
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
        }
        else if(result.equalsIgnoreCase("clear")){
            ChatUtil.sendMessage(player, ChatUtil.fixColor("&aJestes czysty"));
        }

        to_verify.remove(player);

    }
}
