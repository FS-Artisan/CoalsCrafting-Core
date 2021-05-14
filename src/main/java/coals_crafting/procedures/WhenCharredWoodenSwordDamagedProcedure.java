package coals_crafting.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import coals_crafting.item.CoalStickItem;
import coals_crafting.item.CharredWoodenSwordItem;

import coals_crafting.CoalsCraftingModElements;

import coals_crafting.CoalsCraftingMod;

@CoalsCraftingModElements.ModElement.Tag
public class WhenCharredWoodenSwordDamagedProcedure extends CoalsCraftingModElements.ModElement {
	public WhenCharredWoodenSwordDamagedProcedure(CoalsCraftingModElements instance) {
		super(instance, 22);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CoalsCraftingMod.LOGGER.warn("Failed to load dependency entity for procedure WhenCharredWoodenSwordDamaged!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				CoalsCraftingMod.LOGGER.warn("Failed to load dependency itemstack for procedure WhenCharredWoodenSwordDamaged!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == new ItemStack(CharredWoodenSwordItem.block, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(CoalStickItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}

	@SubscribeEvent
	public void onItemDestroyed(PlayerDestroyItemEvent event) {
		Entity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		ItemStack itemstack = event.getOriginal();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		dependencies.put("itemstack", itemstack);
		this.executeProcedure(dependencies);
	}
}
