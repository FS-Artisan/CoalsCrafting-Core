
package coals_crafting.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import coals_crafting.itemgroup.CoalsCraftingTabItemGroup;

import coals_crafting.CoalsCraftingModElements;

@CoalsCraftingModElements.ModElement.Tag
public class CoalAxeItem extends CoalsCraftingModElements.ModElement {
	@ObjectHolder("coals_crafting:coal_axe")
	public static final Item block = null;
	public CoalAxeItem(CoalsCraftingModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.COAL, (int) (1)));
			}
		}, 1, -3.3f, new Item.Properties().group(CoalsCraftingTabItemGroup.tab)) {
		}.setRegistryName("coal_axe"));
	}
}
