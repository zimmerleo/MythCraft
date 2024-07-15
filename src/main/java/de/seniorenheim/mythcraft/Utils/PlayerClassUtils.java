package de.seniorenheim.mythcraft.Utils;

public class PlayerClassUtils {

    public static int transformInvSlotToIndex(int slot) {
        int[] slots = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == slot) {
                return i;
            }
        }
        return -1;
    }

    public static double calculateMaxXP(int characterLevel) {
        return 100 * Math.pow(2, characterLevel);
    }
}
