package mixy.bangui.mixybangui;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class MixyBanGUI extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);
        System.out.println(ChatColor.GREEN + "Plugin Loaded!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(command.getName().equalsIgnoreCase("banmenu"))
        {
            if(sender instanceof Player)
            {
                Player player = (Player) sender;
                Menu.OpenMainMenu(player);
            }
        }
        return true;
    }
}
