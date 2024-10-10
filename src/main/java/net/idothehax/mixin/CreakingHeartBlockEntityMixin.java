//package net.idothehax.mixin;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.CreakingHeartBlock;
//import net.minecraft.entity.damage.DamageSource;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.sound.SoundCategory;
//import net.minecraft.sound.SoundEvents;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.world.Difficulty;
//import net.minecraft.world.GameRules;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(net.minecraft.block.entity.CreakingHeartBlockEntity.class)
//public class CreakingHeartBlockEntityMixin {
//	@Inject(at = @At("HEAD"), method = "tick")
//    private static void tick(World world, BlockPos pos, BlockState state, net.minecraft.block.entity.CreakingHeartBlockEntity blockEntity, CallbackInfo ci) {
//		int i = blockEntity.method_65011();
//		if (blockEntity.field_54910 != i) {
//			blockEntity.field_54910 = i;
//			world.updateComparators(pos, Blocks.CREAKING_HEART);
//		}
//
//		ServerWorld serverWorld;
//		if (blockEntity.trailParticlesSpawnTimer > 0) {
//			if (blockEntity.trailParticlesSpawnTimer > 50) {
//				blockEntity.spawnTrailParticles((ServerWorld)world, 1, true);
//				blockEntity.spawnTrailParticles((ServerWorld)world, 1, false);
//			}
//
//			if (blockEntity.trailParticlesSpawnTimer % 10 == 0 && world instanceof ServerWorld) {
//				serverWorld = (ServerWorld)world;
//				if (blockEntity.lastCreakingPuppetPos != null) {
//					if (blockEntity.creakingPuppet != null) {
//						blockEntity.lastCreakingPuppetPos = blockEntity.creakingPuppet.getBoundingBox().getCenter();
//					}
//
//					Vec3d vec3d = Vec3d.ofCenter(pos);
//					float f = 0.2F + 0.8F * (float)(100 - blockEntity.trailParticlesSpawnTimer) / 100.0F;
//					Vec3d vec3d2 = vec3d.subtract(blockEntity.lastCreakingPuppetPos).multiply((double)f).add(blockEntity.lastCreakingPuppetPos);
//					BlockPos blockPos = BlockPos.ofFloored(vec3d2);
//					float g = (float)blockEntity.trailParticlesSpawnTimer / 2.0F / 100.0F + 0.5F;
//					serverWorld.playSound((PlayerEntity)null, blockPos, SoundEvents.BLOCK_CREAKING_HEART_HURT, SoundCategory.BLOCKS, g, 1.0F);
//				}
//			}
//
//			--blockEntity.trailParticlesSpawnTimer;
//		}
//
//		if (blockEntity.creakingUpdateTimer-- < 0) {
//			blockEntity.creakingUpdateTimer = 20;
//			if (blockEntity.creakingPuppet != null) {
//				if (CreakingHeartBlock.isWorldNaturalAndNight(world) && !(blockEntity.method_65012() > 34.0)) {
//					if (blockEntity.creakingPuppet.isRemoved()) {
//						blockEntity.creakingPuppet = null;
//					}
//
//					if (!CreakingHeartBlock.shouldBeEnabled(state, world, pos) && blockEntity.creakingPuppet == null) {
//						world.setBlockState(pos, (BlockState)state.with(CreakingHeartBlock.CREAKING, CreakingHeartBlock.Creaking.DISABLED), Block.NOTIFY_ALL);
//					}
//
//				} else {
//					blockEntity.onBreak((DamageSource)null);
//				}
//			} else if (!CreakingHeartBlock.shouldBeEnabled(state, world, pos)) {
//				world.setBlockState(pos, (BlockState)state.with(CreakingHeartBlock.CREAKING, CreakingHeartBlock.Creaking.DISABLED), Block.NOTIFY_ALL);
//			} else {
//				if (!CreakingHeartBlock.isWorldNaturalAndNight(world)) {
//					if (state.get(CreakingHeartBlock.CREAKING) == CreakingHeartBlock.Creaking.ACTIVE) {
//						world.setBlockState(pos, (BlockState)state.with(CreakingHeartBlock.CREAKING, CreakingHeartBlock.Creaking.DORMANT), Block.NOTIFY_ALL);
//						return;
//					}
//				} else if (state.get(CreakingHeartBlock.CREAKING) == CreakingHeartBlock.Creaking.DORMANT) {
//					world.setBlockState(pos, (BlockState)state.with(CreakingHeartBlock.CREAKING, CreakingHeartBlock.Creaking.ACTIVE), Block.NOTIFY_ALL);
//					return;
//				}
//
//				if (state.get(CreakingHeartBlock.CREAKING) == CreakingHeartBlock.Creaking.ACTIVE) {
//					if (world.getDifficulty() != Difficulty.PEACEFUL) {
//						if (world instanceof ServerWorld) {
//							serverWorld = (ServerWorld)world;
//							if (!serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
//								return;
//							}
//						}
//
//						PlayerEntity playerEntity = world.getClosestPlayer((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 32.0, false);
//						if (playerEntity != null) {
//							blockEntity.creakingPuppet = spawnCreakingPuppet((ServerWorld)world, blockEntity);
//							if (blockEntity.creakingPuppet != null) {
//								blockEntity.creakingPuppet.playSound(SoundEvents.ENTITY_CREAKING_SPAWN);
//								world.playSound((PlayerEntity)null, blockEntity.getPos(), SoundEvents.BLOCK_CREAKING_HEART_SPAWN, SoundCategory.BLOCKS, 1.0F, 1.0F);
//							}
//						}
//
//					}
//				}
//			}
//		}
//	}
//}