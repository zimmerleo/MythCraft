package de.seniorenheim.mythcraft.Quests.Objectives;

import de.seniorenheim.mythcraft.Entities.CustomEntity;
import org.bukkit.Location;

public class KillObjective extends AbstractObjective {

    private int killed;
    private final int toKill;
    private final CustomEntity entity;

    public KillObjective(AbstractObjective previousObjective, AbstractObjective followingObjective, Location location, int toKill, CustomEntity entity) {
        super(previousObjective, followingObjective, location);
        this.killed = 0;
        this.toKill = toKill;
        this.entity = entity;
    }

    public int getKilled() {
        return killed;
    }

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public int getToKill() {
        return toKill;
    }

    public CustomEntity getEntity() {
        return entity;
    }
}
