package joelkral.theeclipse.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class TestItemTwoItem extends Item
{

	public TestItemTwoItem(Item.Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public ActionResultType useOn(ItemUseContext context) 
	{
		context.getPlayer().giveExperienceLevels(1);
		return ActionResultType.SUCCESS;
	}
}
