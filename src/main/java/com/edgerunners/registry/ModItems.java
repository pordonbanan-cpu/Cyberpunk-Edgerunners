package com.edgerunners.registry;

import com.edgerunners.Edgerunners;
import com.edgerunners.item.SandevistanItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(net.minecraft.core.registries.BuiltInRegistries.ITEM, Edgerunners.MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Edgerunners.MODID);

    public static final DeferredHolder<Item, SandevistanItem> SANDEVISTAN =
            ITEMS.register("sandevistan", () -> new SandevistanItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.edgerunners"))
                    .icon(() -> SANDEVISTAN.get().getDefaultInstance())
                    .displayItems((p, out) -> out.accept(SANDEVISTAN.get()))
                    .build());
}
