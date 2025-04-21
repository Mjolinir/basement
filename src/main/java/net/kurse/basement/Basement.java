package net.kurse.basement;

import net.kurse.basement.block.ModBlocks;
import net.kurse.basement.block.custom.MEProxyBlock;
import net.kurse.basement.enchantment.EnchantmentEffects;
import net.kurse.basement.item.ModItems;
import net.kurse.basement.loot.LootModifiers;
import net.kurse.basement.recipe.ModRecipes;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Basement.MOD_ID)
public class Basement
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "basement";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Basement(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        net.kurse.basement.item.CreativeModeTabs.register(modEventBus);

        //ModEntities.register(modEventBus);
        //ModVillagers.register(modEventBus);
        //ModParticles.register(modEventBus);
        LootModifiers.register(modEventBus);
        //ModBlockEntities.register(modEventBus);

        //ModDataComponents.register(modEventBus);
        //ModSounds.register(modEventBus);
        //ModEffects.register(modEventBus);
        //ModPotions.register(modEventBus);
        EnchantmentEffects.register(modEventBus);
        //ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.URU_BLOCK);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.URU_HAMMER);
            event.accept(ModItems.URU_SWORD);
            event.accept(ModItems.URU_AXE);
            event.accept(ModItems.URU_HELMET);
            event.accept(ModItems.URU_CHESTPLATE);
            event.accept(ModItems.URU_LEGGINGS);
            event.accept(ModItems.URU_BOOTS);
            event.accept(ModItems.URU_HORSE_ARMOR);
            event.accept(ModItems.URU_BOW);
        }

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_URU);
            event.accept(ModItems.URU);
            event.accept(ModItems.KURSE_SMITHING_TEMPLATE);
        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {

        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.URU_LAMP);

        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.URU_ORE);
            event.accept(ModItems.RAW_URU);
            event.accept(ModBlocks.RAW_URU_BLOCK);
            event.accept(ModBlocks.URU_DEEPSLATE_ORE);
            event.accept(ModBlocks.URU_NETHER_ORE);
            event.accept(ModBlocks.URU_END_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.URU_HAMMER);
            event.accept(ModItems.URU_SHOVEL);
            event.accept(ModItems.URU_HOE);
            event.accept(ModItems.URU_PICKAXE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("Basement mod by Kurse is loading...");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {

        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {

        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {

        }
    }
}
