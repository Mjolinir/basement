package net.kurse.basement.item;

import net.kurse.basement.Basement;
import net.kurse.basement.item.custom.HammerItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.kurse.basement.item.custom.ArmorItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Basement.MOD_ID);

    public static final DeferredItem<Item> URU = ITEMS.register("uru", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_URU = ITEMS.register("raw_uru", () -> new Item(new Item.Properties()));


    public static final DeferredItem<HammerItem> URU_HAMMER = ITEMS.register("uru_hammer",
            () -> new HammerItem(ModToolTiers.URU, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.URU, 9F, -3.0f))));

    public static final DeferredItem<SwordItem> URU_SWORD = ITEMS.register("uru_sword",
            () -> new SwordItem(ModToolTiers.URU, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.URU, 7, -2.0f))));
    public static final DeferredItem<PickaxeItem> URU_PICKAXE = ITEMS.register("uru_pickaxe",
            () -> new PickaxeItem(ModToolTiers.URU, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.URU, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> URU_SHOVEL = ITEMS.register("uru_shovel",
            () -> new ShovelItem(ModToolTiers.URU, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.URU, 1.5F, -2.8f))));
    public static final DeferredItem<AxeItem> URU_AXE = ITEMS.register("uru_axe",
            () -> new AxeItem(ModToolTiers.URU, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.URU, 8.0F, -3.2f))));
    public static final DeferredItem<HoeItem> URU_HOE = ITEMS.register("uru_hoe",
            () -> new HoeItem(ModToolTiers.URU, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.URU, 0F, -3.0f))));

    public static final DeferredItem<net.minecraft.world.item.ArmorItem> URU_HELMET = ITEMS.register("uru_helmet",
            () -> new ArmorItem(ArmorMaterials.URU_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))));
    public static final DeferredItem<net.minecraft.world.item.ArmorItem> URU_CHESTPLATE = ITEMS.register("uru_chestplate",
            () -> new ArmorItem(ArmorMaterials.URU_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))));
    public static final DeferredItem<net.minecraft.world.item.ArmorItem> URU_LEGGINGS = ITEMS.register("uru_leggings",
            () -> new ArmorItem(ArmorMaterials.URU_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35))));
    public static final DeferredItem<net.minecraft.world.item.ArmorItem> URU_BOOTS = ITEMS.register("uru_boots",
            () -> new ArmorItem(ArmorMaterials.URU_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))));

    public static final DeferredItem<Item> URU_BOW = ITEMS.register("uru_bow",
            () -> new BowItem(new Item.Properties().durability(500)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if( Screen.hasShiftDown()) {
                        tooltipComponents.add(Component.translatable("tooltip.basement.uru_bow.shift_down"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.basement.uru_bow"));
                    }
                }
            });

    public static final DeferredItem<Item> URU_HORSE_ARMOR = ITEMS.register("uru_horse_armor",
            () -> new AnimalArmorItem(ArmorMaterials.URU_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> KURSE_SMITHING_TEMPLATE = ITEMS.register("kurse_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Basement.MOD_ID, "kurse")));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
