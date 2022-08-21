package net.fantiks.hyukamod.utils;

import net.minecraft.util.math.Vec3f;

public class ItemRescaling {

    private final Vec3f position;
    private final Vec3f scale;

    public ItemRescaling(Vec3f position, Vec3f scale) {
        this.position = position;
        this.scale = scale;
    }

    public Vec3f position() {
        return position;
    }

    public Vec3f scale() {
        return scale;
    }

}
