package mixy.bangui.mixybangui;

import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class MenuClickListener implements Listener
{
    @EventHandler
    public void OnClick(InventoryClickEvent event)
    {
        Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List"))
        {
            if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD))
            {
                Player target = player.getServer().getPlayer(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
                Menu.OpenBanMenu(player, target);
            }
            else if(event.getCurrentItem().getType().equals(Material.BARRIER))
            {
                player.closeInventory();
            }
            event.setCancelled(true);
        }
        else if(event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Ban This Player" + ChatColor.BOLD + "" + ChatColor.YELLOW + " :)"))
        {
            if(event.getCurrentItem().getType().equals(Material.TNT))
            {
                Player target = player.getServer().getPlayer(ChatColor.stripColor(event.getClickedInventory().getItem(4).getItemMeta().getDisplayName()));
                player.getServer().getBanList(BanList.Type.NAME).addBan(target.getDisplayName(), "Good bye", null, "god");
                player.closeInventory();
            }
            else if(event.getCurrentItem().getType().equals(Material.OAK_DOOR))
            {
                player.closeInventory();
                Menu.OpenMainMenu(player);
            }
            else if(event.getCurrentItem().getType().equals(Material.PLAYER_HEAD))
            {
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }
}
