package net.idothehax.creakinghorror.entity.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CreakingHauntStatusEffect extends StatusEffect {
    public CreakingHauntStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x484720); // The value 12171705 corresponds to the RGB color (72, 71, 32), or #484720
    }
}
