package net.idothehax.entity.effect;

import net.idothehax.CreakingHorror;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect CREAKING_HAUNT = new CreakingHauntStatusEffect();


    private static void register() {
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(CreakingHorror.MOD_ID, "creaking_haunt"), CREAKING_HAUNT);
    }
}
