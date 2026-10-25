package com.edgerunners.item;

import com.edgerunners.registry.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/** Надевается в слот нагрудника (ПКМ). Активация — клавиша V. */
public class SandevistanItem extends Item implements Equipable {
    public static final int DURATION = 400;

    public SandevistanItem(Properties props) { super(props); }

    @Override public EquipmentSlot getEquipmentSlot() { return EquipmentSlot.CHEST; }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player p, InteractionHand hand) {
        return swapWithEquipmentSlot(this, level, p, hand);
    }

    public static void toggle(ServerPlayer p) {
        if (!(p.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SandevistanItem)) {
            p.displayClientMessage(Component.translatable("msg.edgerunners.need_implant"), true);
            return;
        }
        if (p.hasEffect(ModEffects.SANDEVISTAN)) {
            p.removeEffect(ModEffects.SANDEVISTAN);
            p.level().playSound(null, p.blockPosition(), SoundEvents.BEACON_DEACTIVATE, SoundSource.PLAYERS, 1f, 2f);
        } else {
            p.addEffect(new MobEffectInstance(ModEffects.SANDEVISTAN, DURATION, 0, false, true, true));
            p.level().playSound(null, p.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 1f, 2f);
        }
    }
}
