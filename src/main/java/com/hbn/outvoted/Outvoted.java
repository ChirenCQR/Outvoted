package com.hbn.outvoted;

import com.hbn.outvoted.entities.hunger.HungerEntity;
import com.hbn.outvoted.entities.inferno.InfernoEntity;
import com.hbn.outvoted.init.ModEntityTypes;
import com.hbn.outvoted.init.ModItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("outvoted")
public class Outvoted {
    public static final String MOD_ID = "outvoted";

    public Outvoted() {
        final FMLJavaModLoadingContext modLoadingContext = FMLJavaModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.INFERNO.get(), InfernoEntity.setCustomAttributes().create());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.HUNGER.get(), HungerEntity.setCustomAttributes().create());
        });
    }

    public static final ItemGroup TAB = new ItemGroup("modTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.DIAMOND_BLOCK);
        }
    };
}
