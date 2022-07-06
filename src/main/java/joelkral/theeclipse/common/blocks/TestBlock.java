package joelkral.theeclipse.common.blocks;

import joelkral.theeclipse.core.init.TileEntityTypeInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class TestBlock extends Block
{

	public TestBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityTypeInit.TEST_TILE.get().create();
	}
}
