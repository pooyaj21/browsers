package Logic;

import java.util.ArrayList;

public class User {
    private ArrayList<Tab> tabs;
    private ArrayList<Group> groups;
    private String name;

    public User(String name) {
        this.name = name;
        tabs = new ArrayList<>();
        groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Tab> getTabs() {
        return tabs;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void addTab(Tab tab) {
        tabs.add(tab);
    }
    public void removeTab(Tab tab){
        tabs.remove(tab);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
    public void removeGroup(Group group){
        groups.remove(group);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User: ").append(name).append("\n");
        for (Tab tab : tabs) {
            if (!tab.haveGroup()) stringBuilder.append("\t- ").append(tab.getName()).append("\n");
        }
        for (Group group : groups) {
            stringBuilder.append("\t- ").append(group.getName()).append("\n");
            for (Tab tab : tabs) {
                if (tab.getGroupId() == group.getId()) {
                    stringBuilder.append("\t\t").append(tab.getName()).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

}
