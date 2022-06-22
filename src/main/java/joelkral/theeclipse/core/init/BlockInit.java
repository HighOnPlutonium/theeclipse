package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.blocks.TestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheEclipse.MOD_ID);
	
	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new TestBlock(Block.Properties.of(Material.METAL)));
}
