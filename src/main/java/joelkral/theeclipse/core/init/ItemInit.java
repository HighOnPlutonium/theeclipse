package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.items.TestItemTwoItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheEclipse.MOD_ID);
	
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties().tab(TheEclipse.MOD_GROUP)));
	
	public static final RegistryObject<Item> TEST_ITEM_TWO = ITEMS.register("test_item_two", () -> new TestItemTwoItem(new Item.Properties().rarity(Rarity.EPIC).tab(TheEclipse.MOD_GROUP)));
	
	public static final RegistryObject<Item> YOUR_MUM = ITEMS.register("your_mum", () -> new Item(new Item.Properties().tab(TheEclipse.MOD_GROUP)));
 }
