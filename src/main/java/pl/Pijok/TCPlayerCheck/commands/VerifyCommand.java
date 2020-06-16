package pl.Pijok.TCPlayerCheck.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import pl.Pijok.TCPlayerCheck.utils.ChatUtil;
import pl.Pijok.TCPlayerCheck.utils.VerifyUtil;

public class VerifyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;

        if(sender.hasPermission("prison.verify")){

            if(args.length == 0){
                ChatUtil.sendMessage(player, ChatUtil.fixColor("&7Uzycie: /" + label + " <nick>"));
                ChatUtil.sendMessage(player, ChatUtil.fixColor("&7Uzycie: /" + label + " <nick> (czysty/cheater/wspolpraca)"));
                return true;
            }

            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null || !target.isOnline()){
                    ChatUtil.sendMessage(player, ChatUtil.fixColor("&cTen gracz jest offline"));
                    return true;
                }

                if(target.getName().equals(sender.getName())){
                    ChatUtil.sendMessage(player, ChatUtil.fixColor("&cNie mozesz sprawdzac samego siebie!"));
                    return true;
                }

                VerifyUtil.add(target);
                VerifyUtil.sendAlert(target);
                ChatUtil.sendMessage(player, ChatUtil.fixColor("&cGracz " + target.getName() + " dostal informacje o sprawdzaniu"));
                for(Player online_player : Bukkit.getOnlinePlayers()){
                    online_player.sendMessage("");
                    ChatUtil.sendMessage(online_player, ChatUtil.fixColor("&c&lGracz " + target.getName() + " jest sprawdzany"));
                    online_player.sendMessage("");
                }
            }
            if(args.length == 2){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null || !target.isOnline()){
                    ChatUtil.sendMessage(player, ChatUtil.fixColor("&cTen gracz jest offline"));
                    return true;
                }

                if(VerifyUtil.contains(target)){
                    if(args[1].equalsIgnoreCase("czysty")){
                        VerifyUtil.result(target,"clear");
                    }
                    else if(args[1].equalsIgnoreCase("cheater")){
                        VerifyUtil.result(target, "cheater");
                    }
                    else if(args[1].equalsIgnoreCase("wspolpraca")){
                        VerifyUtil.result(target,"nocoop");
                    }
                }
                return true;
            }

        }
        else{
            ChatUtil.sendMessage(player, ChatUtil.fixColor("&cNie masz dostepu do tej komendy"));
            return true;
        }


        return true;
    }

}
