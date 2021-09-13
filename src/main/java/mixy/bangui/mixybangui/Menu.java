package mixy.bangui.mixybangui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Menu
{

    public static void OpenMainMenu(Player player)
    {
        ArrayList<Player> ServerPlayers = new ArrayList<>(player.getServer().getOnlinePlayers());
        ServerPlayers.remove(player);

        if(ServerPlayers.size() == 0)
        {
            player.sendMessage(ChatColor.RED + "There is no one on the server that you can ban.");
            return;
        }

        Inventory gui = Bukkit.createInventory(player, 54, ChatColor.BLUE + "Player List");

        for (int i = 0; i < ServerPlayers.size(); i++)
        {
            ItemStack item = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.RED + ServerPlayers.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.AQUA + "Click for ban.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gui.addItem(item);
        }

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta close_meta = close.getItemMeta();
        close_meta.setDisplayName(ChatColor.RED + "CLOSE");
        close.setItemMeta(close_meta);
        gui.setItem(53, close);

        player.closeInventory();
        player.openInventory(gui);
    }

    public static void OpenBanMenu(Player player, Player target)
    {
        Inventory targetBanMenu = Bukkit.createInventory(player, 9, ChatColor.RED + "Ban This Player" + ChatColor.BOLD + "" + ChatColor.YELLOW + " :)");

        ItemStack ban_item = new ItemStack(Material.TNT);
        ItemMeta ban_item_meta = ban_item.getItemMeta();
        ban_item_meta.setDisplayName(ChatColor.RED + "BAN!");
        ArrayList<String> ban_lore = new ArrayList<>();
        ban_lore.add(ChatColor.BLUE + "Click to ban!");
        ban_item_meta.setLore(ban_lore);
        ban_item.setItemMeta(ban_item_meta);
        targetBanMenu.setItem(0, ban_item);

        ItemStack head_item = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta head_item_meta = head_item.getItemMeta();
        head_item_meta.setDisplayName(ChatColor.YELLOW + target.getDisplayName());
        ArrayList<String> head_lore = new ArrayList<>();
        head_lore.add("");
        head_lore.add(ChatColor.LIGHT_PURPLE + "Health: " + ChatColor.RED + Math.ceil(target.getHealth()));
        head_lore.add("");
        head_lore.add(ChatColor.LIGHT_PURPLE + "Level: " + ChatColor.GREEN + player.getLevel());
        head_lore.add("");
        head_lore.add(ChatColor.LIGHT_PURPLE + "GameMode: " + ChatColor.YELLOW + player.getGameMode().name());
        head_item_meta.setLore(head_lore);
        head_item.setItemMeta(head_item_meta);
        targetBanMenu.setItem(4, head_item);

        ItemStack cancel_item = new ItemStack(Material.OAK_DOOR);
        ItemMeta cancel_item_meta = ban_item.getItemMeta();
        cancel_item_meta.setDisplayName(ChatColor.GREEN + "BACK");
        ArrayList<String> cancel_lore = new ArrayList<>();
        cancel_lore.add(ChatColor.BLUE + "Go main menu.");
        cancel_item_meta.setLore(cancel_lore);
        cancel_item.setItemMeta(cancel_item_meta);
        targetBanMenu.setItem(8, cancel_item);

        player.closeInventory();
        player.openInventory(targetBanMenu);
    }
}
