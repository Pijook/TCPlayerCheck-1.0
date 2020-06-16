package pl.Pijok.TCPlayerCheck;

import org.bukkit.plugin.java.JavaPlugin;
import pl.Pijok.TCPlayerCheck.commands.ConfessCommand;
import pl.Pijok.TCPlayerCheck.commands.VerifyCommand;
import pl.Pijok.TCPlayerCheck.listeners.QuitListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("check").setExecutor(new VerifyCommand());
        getCommand("confess").setExecutor(new ConfessCommand());

        getServer().getPluginManager().registerEvents(new QuitListener(), this);

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
