package com.gulledgechristopher398.tricksterillagermod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public
class TricksterIllagerMod implements ModInitializer {
    public static final String MOD_ID = "tricksterillagermod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final EntityType<TricksterIllager> TRICKSTER_ILLAGER = Registry.register(
    BuiltInRegistries.ENTITY_TYPE,
    new ResourceLocation(MOD_ID, "trickster_illager"),
    EntityType.Builder.of(TricksterIllager::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(MOD_ID + ":trickster_illager")
    );

    public static final Item JESTER_HAT = Registry.register(
    BuiltInRegistries.ITEM,
    new ResourceLocation(MOD_ID, "jester_hat"),
    new Item(new Item.Properties().stacksTo(1))
    );

    public static final MobEffect HALLUCINATION_EFFECT = Registry.register(
    BuiltInRegistries.MOB_EFFECT,
    new ResourceLocation(MOD_ID, "hallucination"),
    new MobEffect(MobEffectCategory.HARMFUL, 0xFFFFFF) {
        @Override
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return true;
        }

        @Override
        public void applyEffectTick(net.minecraft.world.entity.LivingEntity entity, int amplifier) {
            if (entity.level().isClientSide) {
                // Client-side hallucination effects
            }
        }
    }
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Trickster Illager Mod");

        // Register the Trickster Illager entity
        Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(MOD_ID, "trickster_illager"), TRICKSTER_ILLAGER);

        // Register the Jester Hat item
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "jester_hat"), JESTER_HAT);

        // Register the Hallucination effect
        Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(MOD_ID, "hallucination"), HALLUCINATION_EFFECT);
    }
}
