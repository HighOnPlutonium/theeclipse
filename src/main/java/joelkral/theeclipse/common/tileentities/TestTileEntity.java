package joelkral.theeclipse.common.tileentities;

import joelkral.theeclipse.core.init.TileEntityTypeInit;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TestTileEntity extends TileEntity
{

	public TestTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public TestTileEntity() {
		this(TileEntityTypeInit.TEST_TILE.get());
	}

}
