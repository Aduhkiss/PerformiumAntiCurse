package net.angusbeefgaming.antiprofpro;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import net.angusbeefgaming.antiprofpro.AntiProfPro;

import net.md_5.bungee.api.ChatColor;

/*
 * Anti Profanity Protection System
 * 
 * Completly Written by Atticus Zambrana
 * 
 */
public class onCurseWord implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
    	// Here is the list for banned words
    	List<String> bannedWords = Arrays.asList("fuck", "cunt", "bitch", "nigger", "nigga", "=3", "dick", "cock", "ass", "asshole", "penis", "pussy", "shit", "fag", "bastard", "slut");
        for (String cens: bannedWords) {
        	// Check it the message contains anything that is in our banned words
            if (event.getMessage().contains(cens)) {
            	// if there is...
            	// Check if they have a bypass
            	if(event.getPlayer().hasPermission("pac.bypass")) {
            		// then ignore them
            		return;
            	}
            	else {
                    Player player = event.getPlayer();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mute " + player.getName() + " Auto-Muted for 1 Hour for Cursing!");
                    player.sendMessage(ChatColor.GOLD + "==========================================");
                    player.sendMessage(ChatColor.GOLD + "We do not accept that kind of language");
                    player.sendMessage(ChatColor.GOLD + "on our server, and have auto-muted you.");
                    player.sendMessage(ChatColor.GOLD + "==========================================");
                    // Stop that TERRIBAL message from being sent
                    event.setCancelled(true);
                    return;
            	}
            }
        }
    }
}
