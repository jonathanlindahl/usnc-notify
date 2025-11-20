package com.example.usncnotify.service;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final JDA jda;
    @Value("${discord.channel.id}")
    private String channelId;

    public NotificationService(JDA jda) {
        this.jda = jda;
    }

    public void Notify(int old, int current) {
        MessageChannel channel = jda.getTextChannelById(channelId);
        if (channel != null) {
            channel.sendMessage(
                String.format("New measurement received!%nOld: %d%nNew: %d%n", old, current)
            ).queue();
        } else {
            throw new IllegalArgumentException("channel not found");
        }
    }
}
