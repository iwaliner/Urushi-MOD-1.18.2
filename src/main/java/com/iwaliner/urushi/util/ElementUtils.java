package com.iwaliner.urushi.util;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.TagUrushi;
import com.iwaliner.urushi.util.interfaces.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

import java.util.List;
import java.util.Random;

public class ElementUtils {

    public  static boolean hasReiryoku(Item item){
        return item instanceof HasReiryokuItem;
    }
    public  static boolean isWoodElementItem(ItemStack stack){
        return stack.is(TagUrushi.WOOD_ELEMENT_ITEM);
    }
    public  static boolean isFireElementItem(ItemStack stack){
        return stack.is(TagUrushi.FIRE_ELEMENT_ITEM);
    }
    public  static boolean isEarthElementItem(ItemStack stack){
        return stack.is(TagUrushi.EARTH_ELEMENT_ITEM);
    }
    public  static boolean isMetalElementItem(ItemStack stack){
        return stack.is(TagUrushi.METAL_ELEMENT_ITEM);
    }
    public  static boolean isWaterElementItem(ItemStack stack){
        return stack.is(TagUrushi.WATER_ELEMENT_ITEM);
    }
    public  static boolean isMiningSpeedChanger(Item item){
        return TagUrushi.woodMiningSpeedChangeItemMap.containsKey(item)
                ||TagUrushi.fireMiningSpeedChangeItemMap.containsKey(item)
                ||TagUrushi.woodMiningSpeedChangeItemMap.containsKey(item)
                ||TagUrushi.earthMiningSpeedChangeItemMap.containsKey(item)
                ||TagUrushi.metalMiningSpeedChangeItemMap.containsKey(item)
                ||TagUrushi.waterMiningSpeedChangeItemMap.containsKey(item);
    }
    public  static boolean isWoodMiningSpeedChanger(Item item){
         return TagUrushi.woodMiningSpeedChangeItemMap.containsKey(item);
    }
    public  static boolean isFireMiningSpeedChanger(Item item){
        return TagUrushi.fireMiningSpeedChangeItemMap.containsKey(item);
    }
    public  static boolean isEarthMiningSpeedChanger(Item item){
        return TagUrushi.earthMiningSpeedChangeItemMap.containsKey(item);
    }
    public  static boolean isMetalMiningSpeedChanger(Item item){
        return TagUrushi.metalMiningSpeedChangeItemMap.containsKey(item);
    }
    public  static boolean isWaterMiningSpeedChanger(Item item){
        return TagUrushi.waterMiningSpeedChangeItemMap.containsKey(item);
    }
    public  static int getExtraMiningPercent(Item item,ElementType elementType){
        if(elementType==ElementType.WoodElement){
            if(ElementUtils.isWoodMiningSpeedChanger(item)){
               return TagUrushi.woodMiningSpeedChangeItemMap.get(item);
            }
        }else if(elementType==ElementType.FireElement){
            if(ElementUtils.isFireMiningSpeedChanger(item)){
                return TagUrushi.fireMiningSpeedChangeItemMap.get(item);
            }
        }else if(elementType==ElementType.EarthElement){
            if(ElementUtils.isEarthMiningSpeedChanger(item)){
                return TagUrushi.earthMiningSpeedChangeItemMap.get(item);
            }
        }else if(elementType==ElementType.MetalElement){
            if(ElementUtils.isMetalMiningSpeedChanger(item)){
                return TagUrushi.metalMiningSpeedChangeItemMap.get(item);
            }
        }else{
            if(ElementUtils.isWaterMiningSpeedChanger(item)){
                return TagUrushi.waterMiningSpeedChangeItemMap.get(item);
            }
        }
        return 0;
    }
    public  static boolean isWoodElement(BlockState state){
        if(state.is(TagUrushi.DISABLE_WOOD_ELEMENT)){
            return false;
        }else if(state.is(TagUrushi.REGISTER_WOOD_ELEMENT)){
            return true;
        }else if(state.getBlock() instanceof CampfireBlock||state.getBlock() instanceof TorchBlock||state.getBlock() instanceof DiodeBlock){
            return false;
        }else if(state.getSoundType()== SoundType.WOOD|| state.getSoundType()== SoundType.LADDER|| state.getSoundType()== SoundType.BAMBOO|| state.getSoundType()== SoundType.BAMBOO_SAPLING||
                 state.getSoundType()== SoundType.SCAFFOLDING||state.getSoundType()== SoundType.AZALEA_LEAVES||state.getSoundType()== SoundType.AZALEA||state.getSoundType()== SoundType.FLOWERING_AZALEA||
                state.getSoundType()== SoundType.STEM
            ){
            return true;
        }else if(state.getBlock() instanceof PistonHeadBlock||state.getBlock() instanceof LeavesBlock||state.getBlock() instanceof SaplingBlock){
            return true;
        }

        return false;
    }
    public  static boolean isFireElement(BlockState state){
        if(state.is(TagUrushi.DISABLE_FIRE_ELEMENT)){
            return false;
        }else if(state.is(TagUrushi.REGISTER_FIRE_ELEMENT)){
            return true;
        }else if(state.getSoundType()== SoundType.NYLIUM|| state.getSoundType()== SoundType.FUNGUS|| state.getSoundType()== SoundType.SHROOMLIGHT|| state.getSoundType()== SoundType.WART_BLOCK||state.getSoundType()== SoundType.NETHERRACK||state.getSoundType()== SoundType.NETHER_BRICKS||
                state.getSoundType()== SoundType.CANDLE||state.getSoundType()== SoundType.NETHER_WART||state.getSoundType()== SoundType.WOOL
        ){
            return true;
        }else if(state.getBlock() instanceof TntBlock||state.getBlock() instanceof AbstractFurnaceBlock||state.getBlock() instanceof CampfireBlock||state.getBlock() instanceof TorchBlock){
            return true;
        }

        return false;
    }
    public  static boolean isEarthElement(BlockState state){
        if(state.is(TagUrushi.DISABLE_EARTH_ELEMENT)){
            return false;
        }else if(state.is(TagUrushi.REGISTER_EARTH_ELEMENT)){
            return true;
        }else if(state.is(Tags.Blocks.NEEDS_GOLD_TOOL)||state.is(Tags.Blocks.NEEDS_NETHERITE_TOOL)||state.is(BlockTags.NEEDS_DIAMOND_TOOL)||state.is(BlockTags.NEEDS_IRON_TOOL)||state.is(BlockTags.NEEDS_STONE_TOOL)){
            return false;
        }else if(state.getBlock() instanceof LeavesBlock||state.getBlock() instanceof SaplingBlock||state.getBlock() instanceof DispenserBlock||state.getBlock() instanceof PistonBaseBlock
                ||state.getBlock() instanceof TntBlock||state.getBlock() instanceof AbstractFurnaceBlock||state.getBlock() instanceof CauldronBlock||state.getBlock() instanceof ShulkerBoxBlock
                ||state.getBlock() instanceof SpongeBlock||state.getBlock() instanceof WetSpongeBlock||state.getBlock() instanceof JukeboxBlock||state.getBlock() instanceof ObserverBlock){
            return false;
        }else if(state.getSoundType()== SoundType.GRAVEL|| state.getSoundType()== SoundType.GRASS|| state.getSoundType()== SoundType.STONE|| state.getSoundType()== SoundType.SAND||
                state.getSoundType()== SoundType.SWEET_BERRY_BUSH||state.getSoundType()== SoundType.CROP||state.getSoundType()== SoundType.HARD_CROP||state.getSoundType()== SoundType.VINE||
                state.getSoundType()== SoundType.ROOTS||state.getSoundType()== SoundType.CALCITE||state.getSoundType()== SoundType.DRIPSTONE_BLOCK||state.getSoundType()== SoundType.POINTED_DRIPSTONE||
                state.getSoundType()== SoundType.CAVE_VINES||state.getSoundType()== SoundType.SPORE_BLOSSOM||state.getSoundType()== SoundType.MOSS||state.getSoundType()== SoundType.MOSS_CARPET||
                state.getSoundType()== SoundType.BIG_DRIPLEAF||state.getSoundType()== SoundType.SMALL_DRIPLEAF||state.getSoundType()== SoundType.ROOTED_DIRT||state.getSoundType()== SoundType.HANGING_ROOTS||
                state.getSoundType()== SoundType.GLOW_LICHEN||state.getSoundType()== SoundType.DEEPSLATE||state.getSoundType()== SoundType.DEEPSLATE_BRICKS||state.getSoundType()== SoundType.DEEPSLATE_TILES||
                state.getSoundType()== SoundType.POLISHED_DEEPSLATE||state.getSoundType()== SoundType.BASALT||state.getSoundType()== SoundType.SOUL_SAND||
                state.getSoundType()== SoundType.SOUL_SOIL||state.getSoundType()== SoundType.TUFF||state.getSoundType()== SoundType.LODESTONE||state.getSoundType()== SoundType.NETHER_SPROUTS
                ||state.getSoundType()== SoundType.WEEPING_VINES||state.getSoundType()== SoundType.TWISTING_VINES

        ){
            return true;
        }

        return false;
    }
    public  static boolean isMetalElement(BlockState state){
        if(state.is(TagUrushi.DISABLE_METAL_ELEMENT)){
            return false;
        }else if(state.is(TagUrushi.REGISTER_METAL_ELEMENT)){
            return true;
        }else if(state.is(Tags.Blocks.NEEDS_GOLD_TOOL)||state.is(Tags.Blocks.NEEDS_NETHERITE_TOOL)||state.is(BlockTags.NEEDS_DIAMOND_TOOL)||state.is(BlockTags.NEEDS_IRON_TOOL)||state.is(BlockTags.NEEDS_STONE_TOOL)){
            return true;
        }else if(state.getSoundType()== SoundType.METAL|| state.getSoundType()== SoundType.ANVIL|| state.getSoundType()== SoundType.LANTERN|| state.getSoundType()== SoundType.NETHER_ORE||
                state.getSoundType()== SoundType.NETHER_GOLD_ORE||state.getSoundType()== SoundType.CHAIN||state.getSoundType()== SoundType.AMETHYST||state.getSoundType()== SoundType.AMETHYST_CLUSTER||
                state.getSoundType()== SoundType.LARGE_AMETHYST_BUD||state.getSoundType()== SoundType.MEDIUM_AMETHYST_BUD||state.getSoundType()== SoundType.SMALL_AMETHYST_BUD||
                state.getSoundType()== SoundType.COPPER||state.getSoundType()== SoundType.BONE_BLOCK||state.getSoundType()== SoundType.GILDED_BLACKSTONE
        ){
            return true;
        }else if(state.getBlock() instanceof DispenserBlock||state.getBlock() instanceof PistonBaseBlock||state.getBlock() instanceof CauldronBlock||state.getBlock() instanceof ShulkerBoxBlock
                ||state.getBlock() instanceof JukeboxBlock||state.getBlock() instanceof ObserverBlock||state.getBlock() instanceof DiodeBlock){
            return true;
        }

        return false;
    }
    public  static boolean isWaterElement(BlockState state){
        if(state.is(TagUrushi.DISABLE_WATER_ELEMENT)){
            return false;
        }else if(state.is(TagUrushi.REGISTER_WATER_ELEMENT)){
            return true;
        }else if(state.getSoundType()== SoundType.LILY_PAD|| state.getSoundType()== SoundType.SNOW|| state.getSoundType()== SoundType.POWDER_SNOW|| state.getSoundType()== SoundType.SLIME_BLOCK||
                state.getSoundType()== SoundType.HONEY_BLOCK||state.getSoundType()== SoundType.WET_GRASS||state.getSoundType()== SoundType.GLASS||state.getSoundType()== SoundType.CORAL_BLOCK
        ){
            return true;
        }else if(state.getBlock() instanceof SpongeBlock||state.getBlock() instanceof WetSpongeBlock){
            return true;
        }

        return false;
    }
    public  static boolean isSpecificElement(ElementType type,BlockState state){
        if(type==ElementType.WoodElement){
            return ElementUtils.isWoodElement(state);
        }else if(type==ElementType.FireElement){
            return ElementUtils.isFireElement(state);
        }else if(type==ElementType.EarthElement){
            return ElementUtils.isEarthElement(state);
        }else if(type==ElementType.MetalElement){
            return ElementUtils.isMetalElement(state);
        }else if(type==ElementType.WaterElement){
            return ElementUtils.isWaterElement(state);
        }else{
            return false;
        }
    }

    public static float countMiningPercentByInventory(Player player, ElementType type)
    {
        float extra=100;
        for (int i = 0; i < player.getInventory().getContainerSize(); ++i)
        {
            ItemStack stack = player.getInventory().getItem(i);

            extra+=ElementUtils.getExtraMiningPercent(stack.getItem(),type)*stack.getCount();
        }

        return extra/100;

    }
    public static void setBreakSpeedInfo(List<Component> list, int i,ElementType type) {
        String s = null;
        ChatFormatting chatFormatting = ChatFormatting.GRAY;
        if (type == ElementType.WoodElement) {
            s = "info.urushi.wood_element_of_block";
            chatFormatting = ChatFormatting.DARK_GREEN;
        } else if (type == ElementType.FireElement) {
            s = "info.urushi.fire_element_of_block";
            chatFormatting = ChatFormatting.DARK_RED;
        } else if (type == ElementType.EarthElement) {
            s = "info.urushi.earth_element_of_block";
            chatFormatting = ChatFormatting.GOLD;
        } else if (type == ElementType.MetalElement) {
            s = "info.urushi.metal_element_of_block";
            chatFormatting = ChatFormatting.GRAY;
        } else if (type == ElementType.WaterElement) {
            s = "info.urushi.water_element_of_block";
            chatFormatting = ChatFormatting.DARK_PURPLE;
        }
        if (i < 0) {
            list.add((new TranslatableComponent("info.urushi.blank").append(i + "% ").append(new TranslatableComponent(s))).withStyle(chatFormatting));
        }else{
            list.add((new TranslatableComponent("info.urushi.blank").append("+"+i + "% ").append(new TranslatableComponent(s))).withStyle(chatFormatting));

        }
    }
    public static boolean isWoodElementMob(LivingEntity entity){
        if(entity instanceof Chicken){
            return true;
        }
        return false;
    }
    public static boolean isFireElementMob(LivingEntity entity){
        if(entity instanceof Sheep){
            return true;
        }
        return false;
    }
    public static boolean isEarthElementMob(LivingEntity entity){
        if(entity instanceof Cow){
            return true;
        }
        return false;
    }
    public static boolean isMetalElementMob(LivingEntity entity){
        if(entity instanceof Horse){
            return true;
        }
        return false;
    }
    public static boolean isWaterElementMob(LivingEntity entity){
        if(entity instanceof Pig){
            return true;
        }
        return false;
    }
    public static boolean isElementMob(LivingEntity entity){
        return isWoodElementMob(entity)||isFireElementMob(entity)||isEarthElementMob(entity)||isMetalElementMob(entity)||isWaterElementMob(entity);
    }
    public static final String REIRYOKU_AMOUNT="stored_reiryoku";

    /**霊力の最大貯蔵可能量を返す**/
    public static int getReiryokuCapacity(ItemStack stack){
        if(stack.getItem() instanceof HasReiryokuItem){
            return ((HasReiryokuItem) stack.getItem()).getReiryokuCapacity();
        }
        return 0;
    }

    /**現在の霊力貯蔵量を返す**/
    public static int getStoredReiryokuAmount(ItemStack stack) {
        if(getReiryokuCapacity(stack)>0) {
            CompoundTag compoundtag = stack.getTag();
            if(compoundtag==null) {
                stack.setTag(new CompoundTag());
                return 0;
            }
                return compoundtag.getInt(REIRYOKU_AMOUNT);

        }else{
            return 0;
        }
    }

    /**霊力貯蔵量を特定の量に変更する**/
    public static void setStoredReiryokuAmount(ItemStack stack,int i) {
        if(0<=i&&i<=getReiryokuCapacity(stack)) {
            CompoundTag compoundtag = stack.getTag();
            if(compoundtag==null) {
                stack.setTag(new CompoundTag());
            }
            stack.getTag().putInt(REIRYOKU_AMOUNT, i);
        }
    }
    /**霊力を増減させるが、結果が0以下や最大容量以上になる場合を考慮していない。**/
    public static void increaseStoredReiryokuAmount(ItemStack stack,int i) {
        CompoundTag compoundtag = stack.getTag();
        int pre=0;
        if(compoundtag==null) {
            stack.setTag(new CompoundTag());
        }else{
            pre=stack.getTag().getInt(REIRYOKU_AMOUNT);
        }
        if(0<=pre+i&&pre+i<=getReiryokuCapacity(stack)) {
            stack.getTag().putInt(REIRYOKU_AMOUNT, pre + i);
        }else if(pre+i>getReiryokuCapacity(stack)){
             stack.getTag().putInt(REIRYOKU_AMOUNT, getReiryokuCapacity(stack));
        }else{
               stack.getTag().putInt(REIRYOKU_AMOUNT, 0);
        }
    }
    /**霊力を増減させたとき、計算結果が定義域に含まれているかどうか**/
    public static boolean willBeInDomain(ItemStack stack,int i){
        CompoundTag compoundtag = stack.getTag();
        int pre=0;
        if(compoundtag==null) {
            stack.setTag(new CompoundTag());

        }else {
             pre = stack.getTag().getInt(REIRYOKU_AMOUNT);
        }
        return 0<=pre+i&&pre+i<=getReiryokuCapacity(stack);
    }

    /**霊力を増減させたとき、定義域からはみ出た端数を返す**/
    public static int getExtraReiryokuAmount(ItemStack stack,int i) {
        CompoundTag compoundtag = stack.getTag();
        int pre=0;
        if(compoundtag==null) {
            stack.setTag(new CompoundTag());
        }else{
             pre=stack.getTag().getInt(REIRYOKU_AMOUNT);
        }

        if(0<=pre+i&&pre+i<=getReiryokuCapacity(stack)) {
            //stack.getTag().putInt(REIRYOKU_AMOUNT, pre + i);
            return 0;
        }else if(pre+i>getReiryokuCapacity(stack)){
            /**霊力を増やしすぎて計算結果が最大容量を超えたとき、入りきらなかった量を正の値で返す。つまり、貯蔵量4990、最大貯蔵量5000にの霊力を30増やそうとすると20が返ってくる。**/
          //  stack.getTag().putInt(REIRYOKU_AMOUNT, getReiryokuCapacity(stack));
            return pre+i-getReiryokuCapacity(stack);
        }else{
            /**霊力を減らしすぎて計算結果が0になったとき、引ききれなかった量を負の値で返す。つまり、貯蔵量10の霊力を90減らそうとすると-80が返ってくる。**/
         //   stack.getTag().putInt(REIRYOKU_AMOUNT, 0);
            return -(i-pre);
        }
    }



    public static boolean isSoukokuBlock(LevelAccessor level, BlockPos pos, BlockState currentState){
        BlockState neighborState=level.getBlockState(pos);
        if(currentState.getBlock()==Blocks.CYAN_CONCRETE_POWDER){
            return neighborState.getBlock()==Blocks.YELLOW_CONCRETE_POWDER;
        }else if(currentState.getBlock()==Blocks.RED_CONCRETE_POWDER){
            return neighborState.getBlock()==Blocks.WHITE_CONCRETE_POWDER;
        }else if(currentState.getBlock()==Blocks.YELLOW_CONCRETE_POWDER){
            return neighborState.getBlock()==Blocks.PURPLE_CONCRETE_POWDER;
        }else if(currentState.getBlock()==Blocks.WHITE_CONCRETE_POWDER){
            return neighborState.getBlock()==Blocks.CYAN_CONCRETE_POWDER;
        }else if(currentState.getBlock()==Blocks.PURPLE_CONCRETE_POWDER){
            return neighborState.getBlock()==Blocks.RED_CONCRETE_POWDER;
        }
        return false;

    }
    public static BlockState getSojoBlock(BlockState currentState){
        if(currentState==null){
            return null;
        }
        if(currentState.getBlock()==Blocks.RED_CONCRETE_POWDER){ //C
            return Blocks.CYAN_CONCRETE_POWDER.defaultBlockState(); //R
        }else if(currentState.getBlock()==Blocks.YELLOW_CONCRETE_POWDER){ //R
            return Blocks.RED_CONCRETE_POWDER.defaultBlockState(); //Y
        }else if(currentState.getBlock()==Blocks.WHITE_CONCRETE_POWDER){ //Y
            return Blocks.YELLOW_CONCRETE_POWDER.defaultBlockState(); //W
        }else if(currentState.getBlock()==Blocks.PURPLE_CONCRETE_POWDER){ //W
            return Blocks.WHITE_CONCRETE_POWDER.defaultBlockState(); //P
        }else if(currentState.getBlock()==Blocks.CYAN_CONCRETE_POWDER){ //P
            return Blocks.PURPLE_CONCRETE_POWDER.defaultBlockState(); //C
        }
        return null;

    }
    public static BlockState getRandomElementBlock(LevelAccessor level){
        int random=level.getRandom().nextInt(5);
        if(random==0){
            return Blocks.CYAN_CONCRETE_POWDER.defaultBlockState();
        }else if(random==1){
            return Blocks.RED_CONCRETE_POWDER.defaultBlockState();
        }else if(random==2){
            return Blocks.YELLOW_CONCRETE_POWDER.defaultBlockState();
        }else if(random==3){
            return Blocks.WHITE_CONCRETE_POWDER.defaultBlockState();
        }else {
            return Blocks.PURPLE_CONCRETE_POWDER.defaultBlockState();
        }
    }
    public static ItemStack getOverflowStack(ElementType type){
        if(type==ElementType.WoodElement){
            return new ItemStack(ItemAndBlockRegister.wood_amber.get());
        }else if(type==ElementType.FireElement){
            return new ItemStack(ItemAndBlockRegister.fire_amber.get());
        }else if(type==ElementType.EarthElement){
            return new ItemStack(ItemAndBlockRegister.earth_amber.get());
        }else if(type==ElementType.MetalElement){
            return new ItemStack(ItemAndBlockRegister.metal_amber.get());
        }else if(type==ElementType.WaterElement){
            return new ItemStack(ItemAndBlockRegister.water_amber.get());
        }else{
            return ItemStack.EMPTY;
        }
    }
}
