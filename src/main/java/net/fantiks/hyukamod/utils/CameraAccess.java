package net.fantiks.hyukamod.utils;

import net.minecraft.entity.Entity;

public interface CameraAccess {

    void setCameraY(float cameraY);

    Entity getFocusedEntity();

}
