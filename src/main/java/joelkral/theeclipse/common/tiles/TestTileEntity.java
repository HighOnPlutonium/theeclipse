package joelkral.theeclipse.common.tiles;

import joelkral.theeclipse.core.init.TileEntityTypeInit;
import net.minecraft.tileentity.TileEntity;

public class TestTileEntity extends TileEntity
{

	public TestTileEntity() {
		super(TileEntityTypeInit.TEST_TILE.get());
	}

}
