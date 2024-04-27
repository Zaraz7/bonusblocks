package luke.bonusblocks;

import luke.bonusblocks.biomes.BonusBiomes;
import luke.bonusblocks.block.BonusBlocks;
import luke.bonusblocks.item.BonusItems;
import luke.bonusblocks.item.ItemRawGold;
import luke.bonusblocks.item.ItemRawIron;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.HashMap;


public class BonusBlocksMod implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
    public static final String MOD_ID = "bonusblocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static int entityID = 300;


    private static final HashMap<String, String> borderMaterialMap = new HashMap<>();
    public static void addBorder(ItemStack stack, String imagePath){
        borderMaterialMap.put(stack.getItemName(), imagePath);
    }
    public static String getBorder(ItemStack stack){
        return borderMaterialMap.get(stack.getItemName());
    }

    @Override
    public void onInitialize() {
        LOGGER.info("BonusBlocks initialized.");
    }

    @Override
    public void beforeClientStart() {
        SoundHelper.Client.addSound("bonusblocks", "chimes.ogg");
        Item.oreRawGold = new ItemRawGold("ore.raw.gold", 16510).setIconCoord(10, 8);
        Item.oreRawIron = new ItemRawIron("ore.raw.iron", 16511).setIconCoord(9, 8);
    }

    @Override
    public void afterClientStart() {
    }

    @Override
    public void beforeGameStart() {
        new BonusBlocks().initializeBlocks();
        new BonusItems().initilizeItems();
        new BonusBiomes().initializeBiomes();

        addBorder(Item.ingotIron.getDefaultStack(), "/assets/bonusblocks/art/border_iron.png");
        addBorder(Item.ingotGold.getDefaultStack(), "/assets/bonusblocks/art/border_gold.png");
        addBorder(Item.ingotSteel.getDefaultStack(), "/assets/bonusblocks/art/border_steel.png");
        addBorder(new ItemStack(Item.dye, 1, 4), "/assets/bonusblocks/art/border_lapis.png");
        addBorder(Item.diamond.getDefaultStack(), "/assets/bonusblocks/art/border_diamond.png");
        addBorder(Item.dustRedstone.getDefaultStack(), "/assets/bonusblocks/art/border_redstone.png");
        addBorder(Item.olivine.getDefaultStack(), "/assets/bonusblocks/art/border_olivine.png");
        addBorder(Item.quartz.getDefaultStack(), "/assets/bonusblocks/art/border_quartz.png");
        addBorder(BonusItems.ingotCopper.getDefaultStack(), "/assets/bonusblocks/art/border_copper.png");
        addBorder(BonusItems.ingotSilver.getDefaultStack(), "/assets/bonusblocks/art/border_silver.png");

    }

    @Override
    public void afterGameStart() {
    }

}