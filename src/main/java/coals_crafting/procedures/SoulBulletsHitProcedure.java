package coals_crafting.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import coals_crafting.CoalsCraftingModElements;

import coals_crafting.CoalsCraftingMod;

@CoalsCraftingModElements.ModElement.Tag
public class SoulBulletsHitProcedure extends CoalsCraftingModElements.ModElement {
	public SoulBulletsHitProcedure(CoalsCraftingModElements instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CoalsCraftingMod.LOGGER.warn("Failed to load dependency entity for procedure SoulBulletsHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 1, (true), (true)));
	}
}
