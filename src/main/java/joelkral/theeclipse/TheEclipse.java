package joelkral.theeclipse;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import joelkral.theeclipse.core.init.EnchantmentInit;
import joelkral.theeclipse.core.init.ItemInit;
import joelkral.theeclipse.core.init.PotionInit;


@Mod(TheEclipse.MOD_ID)
public class TheEclipse 
{
	public static final String MOD_ID = "theeclipse";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup MOD_GROUP = new ModGroup("modtab");

    public TheEclipse() 
    {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        
        ItemInit.ITEMS.register(bus);
        EnchantmentInit.ENCHANTS.register(bus);
        PotionInit.EFFECTS.register(bus);
        PotionInit.POTIONS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) 
    {
		event.enqueueWork( () -> 
		{
		BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), Ingredient.of(new ItemStack(Items.ANVIL)), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.TEST_POTION.get()));
		} );
    }
    
    public static class ModGroup extends ItemGroup 
    {

		public ModGroup(String label) 
		{
			super(label);
		}

		@Override
		public ItemStack makeIcon() 
		{
			return ItemInit.TEST_ITEM.get().getDefaultInstance();
		}
    	
    }
}

//    :D happy