package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.tjxjnoobie.ffa.FFA;

public class Killstreaks implements CommandExecutor
{
	
	

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
    	
        if(args.length != 3)
        {
            
            sender.sendMessage("§cError§4> §cUsage§f: §4/econ set|add|remove <player> <amount>");
            return true;
        }

        if(args[0].equalsIgnoreCase("add"))
        {
            if(!FFA.hasAccount(args[1]))
            {
                sender.sendMessage("§cError§4> §4Player does not have an account");
                return true;
            }
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }catch (Exception e)
            {
                sender.sendMessage("You gotta enter in a number bro");
                return true;
            }

            FFA.setBalance(args[1], FFA.getBalance(args[1])  + amount);
        }else if (args[0].equalsIgnoreCase("remove"))
        {
            if(!FFA.hasAccount(args[1]))
            {
                sender.sendMessage("§cError§4> §4Player does not have an account");
                return true;
            }
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }catch (Exception e)
            {
                sender.sendMessage("§cError§4> §cYou most enter a §4§ldigit.");
                return true;
            }

            FFA.setBalance(args[1], FFA.getBalance(args[1]) - amount);
        }else if (args[0].equalsIgnoreCase("set"))
        {
            if(!FFA.hasAccount(args[1]))
            {
                sender.sendMessage("Error: Player does not have an account");
                return true;
            }
            double amount = 0;
            try
            {
                amount = Double.parseDouble(args[2]);
            }catch (Exception e)
            {
                sender.sendMessage("You gotta enter in a number bro");
                return true;
            }

            FFA.setBalance(args[1], amount);
            sender.sendMessage("§6§lNA§f> §eYou gave §6§l " + args[1] + amount);
        }else
        {
            sender.sendMessage("Incorrect argument");
        }
        return true;
    }
}
