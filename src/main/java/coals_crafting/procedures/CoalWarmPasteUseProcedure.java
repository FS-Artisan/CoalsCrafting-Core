package coals_crafting.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import coals_crafting.item.CoalWarmPasteItem;

import coals_crafting.CoalsCraftingModElements;

import coals_crafting.CoalsCraftingMod;

@CoalsCraftingModElements.ModElement.Tag
public class CoalWarmPasteUseProcedure extends CoalsCraftingModElements.ModElement {
	public CoalWarmPasteUseProcedure(CoalsCraftingModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CoalsCraftingMod.LOGGER.warn("Failed to load dependency entity for procedure CoalWarmPasteUse!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(CoalWarmPasteItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 200, (int) 2, (false), (true)));
	}
}
