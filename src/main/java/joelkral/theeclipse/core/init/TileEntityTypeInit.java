package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.tiles.TestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit 
{public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TheEclipse.MOD_ID);
	
	public static final RegistryObject<TileEntityType<TestTileEntity>> TEST_TILE = TILE_ENTITY_TYPES.register("test_tile", () -> TileEntityType.Builder.of(TestTileEntity::new, BlockInit.TEST_BLOCK.get()).build(null));
}
