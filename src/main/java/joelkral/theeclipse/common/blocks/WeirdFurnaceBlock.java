package joelkral.theeclipse.common.blocks;

import java.util.Random;

import joelkral.theeclipse.common.tiles.WeirdFurnaceTileEntity;
import joelkral.theeclipse.core.init.ModTileEntityTypes;
import joelkral.theeclipse.core.util.ModItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class WeirdFurnaceBlock extends Block
{
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public WeirdFurnaceBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) 
	{
		return ModTileEntityTypes.WEIRD_FURNACE.get().create();
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(FACING, LIT);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) 
	{
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
		
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) 
	{
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}
	
	@Override
    public BlockState getStateForPlacement(BlockItemUseContext context) 
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override
    public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) 
    {
        if (stack.hasCustomHoverName()) 
        {
           TileEntity tile = worldIn.getBlockEntity(pos);
           if (tile instanceof WeirdFurnaceTileEntity) 
           {
              ((WeirdFurnaceTileEntity)tile).setCustomName(stack.getHoverName());
           }
        }
     }
    
    @Override
    public int getAnalogOutputSignal(BlockState state, World worldIn, BlockPos pos) 
    {
        return Container.getRedstoneSignalFromBlockEntity(worldIn.getBlockEntity(pos));
    }
    
    @Override
    public boolean hasAnalogOutputSignal(BlockState state)
    {
        return true;
    }
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
       if (state.getValue(LIT)) {
          double d0 = (double)pos.getX() + 0.5D;
          double d1 = (double)pos.getY();
          double d2 = (double)pos.getZ() + 0.5D;
          if (rand.nextDouble() < 0.1D) {
        	  worldIn.playLocalSound(d0, d1, d2, SoundEvents.BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
          }

          Direction direction = state.getValue(FACING);
          Direction.Axis direction$axis = direction.getAxis();
          double d4 = rand.nextDouble() * 0.6D - 0.3D;
          double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
          double d6 = rand.nextDouble() * 9.0D / 16.0D;
          double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
          worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
       }
    }
    
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn != null && !worldIn.isClientSide) {
			TileEntity tile = worldIn.getBlockEntity(pos);
			if (tile instanceof WeirdFurnaceTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}
    
	@Override
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getBlockEntity(pos);
		if (tile instanceof WeirdFurnaceTileEntity && state.getBlock() != newState.getBlock()) {
			WeirdFurnaceTileEntity furnace = (WeirdFurnaceTileEntity) tile;
			((ModItemHandler) furnace.getInventory()).toNonNullList().forEach(item -> {
				@SuppressWarnings("unused")
				ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
			});
		}

		if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
			worldIn.removeBlockEntity(pos);
		}
	}
}
