
package coals_crafting.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import coals_crafting.itemgroup.CoalsCraftingTabItemGroup;

import coals_crafting.CoalsCraftingModElements;

@CoalsCraftingModElements.ModElement.Tag
public class NetheriteCoalItem extends CoalsCraftingModElements.ModElement {
	@ObjectHolder("coals_crafting:netherite_coal")
	public static final Item block = null;
	public NetheriteCoalItem(CoalsCraftingModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CoalsCraftingTabItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.RARE));
			setRegistryName("netherite_coal");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
