/*
BukkitLib not created by the developers of this plugin
Plugin AlexUtilsMod is public and open source
To find bukkit lib go to https://github.com/Pravian/BukkitLib
(C) RedTheDragon_ 2015 - 2015 This Plugin
 */
package me.redthedragon.dragonutils.commands;

import me.redthedragon.dragonutils.DragonUtils;
import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.command.CommandPermissions;
import net.pravian.bukkitlib.command.SourceType;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * DragonUtils Command
 * @author RedTheDragon_
 */
// Using BukkitLib permissions 
@CommandPermissions(source = SourceType.ANY)
public class Command_dragonutilsmod extends BukkitCommand<DragonUtils> {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (args.length > 0) {
            return showUsage();
        }
        sender.sendMessage(ChatColor.BLUE + "DragonUtils created by RedTheDragon_!");
        sender.sendMessage(ChatColor.BLUE + "Running Version " + ChatColor.GREEN + this.plugin.getVersion() + "!");
        return true;
    }
    
}
