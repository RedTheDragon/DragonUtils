/*
BukkitLib not created by the developers of this plugin
Plugin AlexUtilsMod is public and open source
To find bukkit lib go to https://github.com/Pravian/BukkitLib
(C) RedTheDragon_ 2015 - 2015 This Plugin
 */
package me.redthedragon.dragonutils;

import me.redthedragon.dragonutils.commands.Command_dragonutilsmod;
import net.pravian.bukkitlib.BukkitLib;
import net.pravian.bukkitlib.command.BukkitCommandHandler;
import net.pravian.bukkitlib.config.YamlConfig;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import net.pravian.bukkitlib.util.LoggerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Main class for DragonUtilsMod
 * @author RedTheDragon_
 */
public class DragonUtils extends BukkitPlugin {
    
    public DragonUtils plugin;
    public YamlConfig config;
    public BukkitCommandHandler handler;
    
    
    @Override
    public void onLoad()
    {
       this.plugin = this;
       this.handler = new BukkitCommandHandler(plugin);
       config.load();
       
       register(new DUM_Listener());
       
    }  
    
    @Override 
    public void onEnable() 
    {
        BukkitLib.init(plugin);
        register(new DUM_Listener());
        config = new YamlConfig(plugin, "config.yml", true);
        config.load();
        handler.setCommandLocation(Command_alexutilsmod.class.getPackage());
        LoggerUtils.info(plugin, "Running on " + config.getString("server-name"));
        LoggerUtils.info(plugin, "Version " + plugin.getVersion() + " has been enabled! Created by " + plugin.getAuthors());
    }
    @Override 
    public void onDisable()
    {
        config.save();
        LoggerUtils.info(plugin, "Version " + plugin.getVersion() + " has been disabled! Created by " + plugin.getAuthors());
        LoggerUtils.info(plugin, "Thanks for using " + plugin.getName() + "!");
    }
    
    @Override 
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return handler.handleCommand(sender, cmd, commandLabel, args);
    }
}
