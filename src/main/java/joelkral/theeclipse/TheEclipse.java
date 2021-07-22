package joelkral.theeclipse;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import joelkral.theeclipse.core.init.ItemInit;


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
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) 
    {
    	
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