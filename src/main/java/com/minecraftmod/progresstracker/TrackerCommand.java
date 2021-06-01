package com.minecraftmod.progresstracker;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class TrackerCommand extends CommandBase{

    @Override
    public String getName() {
        return "tracker";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/tracker <block> <amount>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {

        ProgressTracker pt = new ProgressTracker();
        ProgressTracker.logger.info("Execute called");
        String message = "";


        if (args != null && args.length > 0) {
            if (args.length == 2) {
                Item item = Item.getByNameOrId(args[0]);
                int amount = Integer.parseInt(args[1]);
                // item.getRegistryName() = minecraft:name
                // is null if block is invalid
                if (item != null && amount > 0) {
                    Counter item_counter = new Counter(item, amount);
                    pt.active_counter.add(item_counter);

                    message = "Item: "+item.getRegistryName()+", Amount: "+amount;
                    TextComponentString text = new TextComponentString(message);
                    sender.sendMessage(text);
                } else {
                    message = "This is not a block: " +args[0];
                    TextComponentString text = new TextComponentString(message);
                    sender.sendMessage(text);
                }

            } else {
                message = "Invalid parameters";
                TextComponentString text = new TextComponentString(message);
                sender.sendMessage(text);
            }
        } else {
            message = "Must input two parameter: block and amount";
            TextComponentString text = new TextComponentString(message);
            sender.sendMessage(text);
        }
    }
}
