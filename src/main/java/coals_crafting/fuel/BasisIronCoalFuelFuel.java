
package coals_crafting.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import coals_crafting.item.BasisIronCoalItem;

import coals_crafting.CoalsCraftingModElements;

@CoalsCraftingModElements.ModElement.Tag
public class BasisIronCoalFuelFuel extends CoalsCraftingModElements.ModElement {
	public BasisIronCoalFuelFuel(CoalsCraftingModElements instance) {
		super(instance, 19);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(BasisIronCoalItem.block, (int) (1)).getItem())
			event.setBurnTime(4800);
	}
}
