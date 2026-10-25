package com.edgerunners;

import com.edgerunners.item.SandevistanItem;
import com.edgerunners.network.ActivatePayload;
import com.edgerunners.registry.ModEffects;
import com.edgerunners.registry.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@Mod(Edgerunners.MODID)
public class Edgerunners {
    public static final String MODID = "edgerunners";

    public Edgerunners(IEventBus modBus) {
        ModEffects.EFFECTS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModItems.TABS.register(modBus);
        modBus.addListener(Edgerunners::payloads);
    }

    private static void payloads(RegisterPayloadHandlersEvent e) {
        e.registrar("1").playToServer(ActivatePayload.TYPE, ActivatePayload.CODEC,
                (p, ctx) -> ctx.enqueueWork(() -> {
                    if (ctx.player() instanceof ServerPlayer sp) SandevistanItem.toggle(sp);
                }));
    }
}
