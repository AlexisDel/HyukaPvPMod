package net.fantiks.hyukamod.registry;

import net.fantiks.hyukamod.utils.ItemRescaling;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3f;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemRescalingRegistry {

    private static final Map<Item, ItemRescaling> map = new HashMap<>();

    public static void register(Item item, ItemRescaling itemRescaling) {
        map.put(item, itemRescaling);
    }

    public static Optional<ItemRescaling> find(Item item) {
        return Optional.ofNullable(map.get(item));
    }

    public static void init() {
        register(Items.BOW, new ItemRescaling(new Vec3f(0f, 0.05f, 0.04f), new Vec3f(0.93f, 1f, 1f)));
        register(Items.FISHING_ROD, new ItemRescaling(new Vec3f(0.08f, -0.027f, -0.33f), new Vec3f(0.93f, 1f, 1f)));
    }

}
