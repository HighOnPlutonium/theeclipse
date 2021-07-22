package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.potions.TestEffect;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionInit 
{
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, TheEclipse.MOD_ID);
	
	public static final RegistryObject<Effect> TEST_EFFECT = EFFECTS.register("test_effect", () -> new TestEffect(EffectType.BENEFICIAL, 0).addAttributeModifier(Attributes.ARMOR, java.util.UUID.randomUUID().toString(), 4.0D, AttributeModifier.Operation.ADDITION));
	
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, TheEclipse.MOD_ID);
	
	public static final RegistryObject<Potion> TEST_POTION = POTIONS.register("test_effect", () -> new Potion(new EffectInstance(PotionInit.TEST_EFFECT.get(), 3600)));
}

