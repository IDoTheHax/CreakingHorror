package net.idothehax.creakinghorror.mixin;

import net.minecraft.entity.mob.CreakingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CreakingEntity.class)
public class CreakingEntityMixin {

    //@Inject(at = @At("HEAD"), method = ,cancellable = true)
//
    //private DefaultAttributeContainer.Builder createCreakingAttributes() {
    //    // Create base attributes
    //    DefaultAttributeContainer.Builder builder = HostileEntity.createHostileAttributes()
    //            .add(EntityAttributes.MAX_HEALTH, 1.0)
    //            .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
    //            .add(EntityAttributes.ATTACK_DAMAGE, 2.0)
    //            .add(EntityAttributes.FOLLOW_RANGE, 32.0)
    //            .add(EntityAttributes.STEP_HEIGHT, 1.0);
//
    //    // Buff attributes if conditions are met
    //    // Assuming you have a way to get the player from your entity's context
    //    if (isPlayerInPaleGarden()) {
    //        builder.add(EntityAttributes.ATTACK_DAMAGE, 4.0); // Buff attack damage
    //        builder.add(EntityAttributes.MAX_HEALTH, 5.0); // Buff max health
    //    }
//
    //    return builder;
    //}
//
    //private boolean isPlayerInPaleGarden() {
    //    // You can implement your logic here to check if any nearby players
    //    // have the bad omen effect and are in the pale_garden biome.
    //    // This is a stub, and you will need to adjust the logic to get the actual player entity.
//
    //    // For demonstration, let's assume we can get the server world
    //    ServerWorld world = (ServerWorld) ((TransientCreakingEntity) (Object) this).getWorld();
    //    BlockPos pos = ((TransientCreakingEntity) (Object) this).getBlockPos();
//
    //    for (PlayerEntity player : world.getPlayers()) {
    //        // Check if player has bad omen and is in the pale garden biome
    //        if (player.hasStatusEffect(StatusEffects.BAD_OMEN) && isInPaleGardenBiome(player)) {
    //            return true;
    //        }
    //    }
    //    return false;
    //}
//
    //@Unique
    //private boolean isInPaleGardenBiome(PlayerEntity player) {
    //    BlockPos pos = player.getBlockPos();
    //    RegistryEntry<Biome> biomeEntry = player.getWorld().getBiome(pos);
    //    RegistryKey<Biome> paleGardenKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("minecraft", "pale_garden"));
//
    //    // Check if the biome key matches pale_garden
    //    return biomeEntry.getKey().map(biomeKey -> {
    //        boolean isInBiome = biomeKey.equals(paleGardenKey);
    //        if (isInBiome) {
    //            CreakingHorror.LOGGER.info("WE GONNA BE CREAKING WIHT THIS ONE");
    //            return true;
    //        }
    //        return false;
    //    }).orElse(false);
    //}

}
