package joelkral.theeclipse.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class TestEnchantment extends Enchantment 
{

	public TestEnchantment() 
	{
		super(Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
	}
	
    @Override
    public int getMaxLevel() 
    {
        return 10;
    }
    
    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) 
    {
        if (target instanceof LivingEntity) 
        {
            LivingEntity livingentity = (LivingEntity) target;
            livingentity.hurt(DamageSource.MAGIC, (float) (0.5+level*0.5));
            user.setHealth(user.getHealth()+(float) (0.5+level*0.5));
        }
    }
}