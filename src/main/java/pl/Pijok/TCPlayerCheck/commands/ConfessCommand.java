package pl.Pijok.TCPlayerCheck.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.Pijok.TCPlayerCheck.utils.ChatUtil;
import pl.Pijok.TCPlayerCheck.utils.VerifyUtil;

public class ConfessCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if(VerifyUtil.contains(player)){
            VerifyUtil.result(player, "cheater");
        }
        else{
            ChatUtil.sendMessage(player, ChatUtil.fixColor("&cNie jestes sprawdzany/a!"));
        }

        return true;
    }
}
