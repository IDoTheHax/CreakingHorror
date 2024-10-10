package net.idothehax.creakinghorror.entity.effect;

import net.idothehax.creakinghorror.CreakingHorror;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect CREAKING_HAUNT = new CreakingHauntStatusEffect();


    public static void register() {
        Registry.register(Registries.STATUS_EFFECT, Identifier.of(CreakingHorror.MOD_ID, "creaking_haunt"), CREAKING_HAUNT);
    }
}
