package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.blocks.WeirdFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheEclipse.MOD_ID);
	
	public static final RegistryObject<Block> WEIRD_FURNACE = BLOCKS.register("weird_furnace", () -> new WeirdFurnaceBlock(Block.Properties.copy(Blocks.FURNACE)));
}
