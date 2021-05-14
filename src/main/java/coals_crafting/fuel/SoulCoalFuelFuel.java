
package coals_crafting.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import coals_crafting.item.SoulCoalItem;

import coals_crafting.CoalsCraftingModElements;

@CoalsCraftingModElements.ModElement.Tag
public class SoulCoalFuelFuel extends CoalsCraftingModElements.ModElement {
	public SoulCoalFuelFuel(CoalsCraftingModElements instance) {
		super(instance, 70);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(SoulCoalItem.block, (int) (1)).getItem())
			event.setBurnTime(30000);
	}
}
