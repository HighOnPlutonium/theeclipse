package joelkral.theeclipse.core.init;

import joelkral.theeclipse.TheEclipse;
import joelkral.theeclipse.common.blocks.WeirdFurnaceBlock;
import joelkral.theeclipse.common.tiles.WeirdFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes 
{
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TheEclipse.MOD_ID);
	
	public static final RegistryObject<TileEntityType<WeirdFurnaceTileEntity>> WEIRD_FURNACE = TILE_ENTITY_TYPES.register("weird_furnace", () -> TileEntityType.Builder.create((WeirdFurnaceTileEntity::new, BlockInit.WEIRD_FURNACE.get()).build(null)));
}
