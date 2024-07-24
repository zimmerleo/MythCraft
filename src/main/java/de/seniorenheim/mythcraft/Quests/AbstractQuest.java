package de.seniorenheim.mythcraft.Quests;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class AbstractQuest {

    private final String name;
    private final List<String> description;
    private final int requiredLevel;

    private final double xpReward;
    private final List<ItemStack> itemRewards;

    private QuestState state;
    private final AbstractQuest previousQuest;
    private final AbstractQuest followingQuest;

    public AbstractQuest(String name, List<String> description, int requiredLevel, double xpReward, List<ItemStack> itemRewards, AbstractQuest previousQuest, AbstractQuest followingQuest) {
        this.name = name;
        this.description = description;
        this.requiredLevel = requiredLevel;
        this.xpReward = xpReward;
        this.itemRewards = itemRewards;
        this.previousQuest = previousQuest;
        this.followingQuest = followingQuest;
        this.state = QuestState.LOCKED;
    }


    public String getName() {
        return name;
    }

    public List<String> getDescription() {
        return description;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public double getXpReward() {
        return xpReward;
    }

    public List<ItemStack> getItemRewards() {
        return itemRewards;
    }

    public QuestState getState() {
        return state;
    }

    public void setState(QuestState state) {
        this.state = state;
    }

    public AbstractQuest getPreviousQuest() {
        return previousQuest;
    }

    public AbstractQuest getFollowingQuest() {
        return followingQuest;
    }
}
