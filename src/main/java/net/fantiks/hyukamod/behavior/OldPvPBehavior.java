package net.fantiks.hyukamod.behavior;

import net.minecraft.util.math.Box;

public class OldPvPBehavior {

    public Box increaseHitBox(Box box){
        return box.stretch(0.1, 0.1, 0.1);
    }
}
