package net.idothehax.creakinghorror.mixin;

import net.idothehax.creakinghorror.CreakingHorror;
import net.idothehax.creakinghorror.entity.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.raid.Raid;
import net.minecraft.world.Difficulty;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.entity.effect.BadOmenStatusEffect")
public class BadOmenStatusEffectMixin {
    @Inject(at = @At("HEAD"), method = "applyUpdateEffect", cancellable = true)
    public void applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier, CallbackInfoReturnable ci) {
        if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
            BlockPos playerPos = serverPlayerEntity.getBlockPos();
            // Get the biome at the player's position
            RegistryEntry<Biome> biomeEntry = world.getBiome(playerPos);
            Biome biome = biomeEntry.value(); // Get the actual biome instance

            // Create a registry key for pale_garden
            RegistryKey<Biome> paleGardenKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("minecraft", "pale_garden"));

            // Log player position and biome
            CreakingHorror.LOGGER.info("Biome at Player Position: " + biome);

            if (!serverPlayerEntity.isSpectator() && world.getDifficulty() != Difficulty.PEACEFUL) {
                if (world.isNearOccupiedPointOfInterest(serverPlayerEntity.getBlockPos())) {
                    Raid raid = world.getRaidAt(serverPlayerEntity.getBlockPos());
                    if (raid == null || raid.getBadOmenLevel() < raid.getMaxAcceptableBadOmenLevel()) {
                        serverPlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RAID_OMEN, 600, amplifier));
                        serverPlayerEntity.setStartRaidPos(serverPlayerEntity.getBlockPos());
                        ci.setReturnValue(false);
                    }
                }

                biomeEntry.getKey().ifPresent(biomeKey -> {
                    RegistryEntry<StatusEffect> creakingHauntEntry = Registries.STATUS_EFFECT.getEntry(ModStatusEffects.CREAKING_HAUNT);

                    if (biomeKey.equals(paleGardenKey)) {
                        serverPlayerEntity.addStatusEffect(new StatusEffectInstance(creakingHauntEntry, 600, amplifier));

                    }
                });
            }
        }

        ci.setReturnValue(true);
    }
}
