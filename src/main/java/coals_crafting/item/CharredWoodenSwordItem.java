
package coals_crafting.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import coals_crafting.itemgroup.CoalsCraftingTabItemGroup;

import coals_crafting.CoalsCraftingModElements;

@CoalsCraftingModElements.ModElement.Tag
public class CharredWoodenSwordItem extends CoalsCraftingModElements.ModElement {
	@ObjectHolder("coals_crafting:charred_wooden_sword")
	public static final Item block = null;
	public CharredWoodenSwordItem(CoalsCraftingModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 20;
			}

			public float getEfficiency() {
				return 0.7f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.CHARCOAL, (int) (1)));
			}
		}, 3, -3.4f, new Item.Properties().group(CoalsCraftingTabItemGroup.tab)) {
		}.setRegistryName("charred_wooden_sword"));
	}
}
