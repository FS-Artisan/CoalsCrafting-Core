
package coals_crafting.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import coals_crafting.item.SoulCoalGunItem;

import coals_crafting.CoalsCraftingModElements;

@CoalsCraftingModElements.ModElement.Tag
public class CoalsCraftingTabItemGroup extends CoalsCraftingModElements.ModElement {
	public CoalsCraftingTabItemGroup(CoalsCraftingModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcoals_crafting_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SoulCoalGunItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
