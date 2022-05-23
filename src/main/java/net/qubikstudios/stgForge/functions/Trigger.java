package net.qubikstudios.stgForge.functions;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.qubikstudios.stgForge.config.MainConfig;

@Mod.EventBusSubscriber
public class Trigger {
    public static void treeMealer(TickEvent.PlayerTickEvent event) {
        if (event.player == null) return;
        if (!event.player.isSpectator()) {
            if (event.phase == TickEvent.Phase.END) {
                Entity entity = event.player;
                String tag = "minecraft:saplings";

                Core.execute(entity.level, entity, MainConfig.COMMON.cropMealRadius.get(),
                        (double) MainConfig.COMMON.cropMealChance.get(), tag);
            }
        }
    }

    public static void cropMealer(TickEvent.PlayerTickEvent event) {
        if (event.player == null) return;
        if (!event.player.isSpectator()) {
            if (event.phase == TickEvent.Phase.END && MainConfig.COMMON.enableCustomTag.get()) {
                Entity entity = event.player;
                String tag = "minecraft:crops";

                Core.execute(entity.level, entity, MainConfig.COMMON.cropMealRadius.get(),
                        (double) MainConfig.COMMON.cropMealChance.get(), tag);
            }
        }
    }

    public static void customTagMealer(TickEvent.PlayerTickEvent event) {
        if (event.player == null) return;
        if (!event.player.isSpectator()) {
            if (event.phase == TickEvent.Phase.END) {
                Entity entity = event.player;
                for (String tag : MainConfig.COMMON.customTag.get()) {
                    Core.execute(entity.level, entity, MainConfig.COMMON.customTagMealRadius.get(),
                            (double) MainConfig.COMMON.customTagMealChance.get(), tag);
                }
            }
        }
    }
}