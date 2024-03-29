package com.krupoderov.discordbot.commands.filter;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Класс, в котором происходит описание команд включения и выключения предупреждающего сообщения
 * в случае употребления запрещенных слов
 *
 * @version 1.0
 * @author Krupoderov Mikhail
 */
public class FilterMessage extends ListenerAdapter {

    public static boolean allowed = true;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        if (e.getMessage().getContentRaw().equalsIgnoreCase("!filtermessage") && allowed == true) {
            e.getChannel().sendMessage("Filter Response Has Been Disabled").queue();
            System.out.println("Disabled");
            allowed = false;
        } else if (e.getMessage().getContentRaw().equalsIgnoreCase("!filtermessage") && allowed == false) {
            e.getChannel().sendMessage("Filter Response Has Been Enabled").queue();
            System.out.println("Enabled");
            allowed = true;
        }
    }
}