package joelkral.theeclipse.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class TrueDefEnchantment extends Enchantment
{
	public TrueDefEnchantment() 
	{
		super(Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
	}

    @Override
    public int getMaxLevel() 
    {
        return 5;
    }
    
    
}
