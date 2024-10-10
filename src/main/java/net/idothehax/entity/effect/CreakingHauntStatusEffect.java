package net.idothehax.entity.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CreakingHauntStatusEffect extends StatusEffect {
    public CreakingHauntStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xFFAA00); // 0xFFAA00 is the color
    }
}
