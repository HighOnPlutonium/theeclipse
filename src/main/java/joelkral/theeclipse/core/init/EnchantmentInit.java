package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.enchantments.TestEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit 
{
	public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheEclipse.MOD_ID);
	
	public static final RegistryObject<Enchantment> TEST_ENCHANTMENT = ENCHANTS.register("test", TestEnchantment::new);
}
