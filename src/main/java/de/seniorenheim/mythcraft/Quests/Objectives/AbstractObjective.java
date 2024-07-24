package de.seniorenheim.mythcraft.Quests.Objectives;

import org.bukkit.Location;

abstract class AbstractObjective {
    
    protected final AbstractObjective previousObjective;
    protected final AbstractObjective followingObjective;
    protected final Location location;

    public AbstractObjective(AbstractObjective previousObjective, AbstractObjective followingObjective, Location location) {
        this.previousObjective = previousObjective;
        this.followingObjective = followingObjective;
        this.location = location;
    }

    public AbstractObjective getPreviousObjective() {
        return previousObjective;
    }

    public AbstractObjective getFollowingObjective() {
        return followingObjective;
    }

    public Location getLocation() {
        return location;
    }
}
