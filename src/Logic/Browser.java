package Logic;


public class Browser {
    private static Browser instance;

    private Browser() {
    }

    public static Browser getInstance() {
        if (instance == null) {
            synchronized (Browser.class) {
                if (instance == null) {
                    instance = new Browser();
                }
            }
        }
        return instance;
    }

    public void createTab(User user, String name) {
        user.addTab(new Tab(name));
    }

    public void createTab(User user, Tab tab) {
        user.addTab(tab);
    }

    public void removeTab(User user, Tab tab) {
        user.removeTab(tab);
    }

    public void createGroup(User user, String name) {
        user.addGroup(new Group(name));
    }

    public void createGroup(User user, Group group) {
        user.addGroup(group);
    }

    public void removeGroup(User user, Group group) {
        user.removeGroup(group);
    }

    public void addTabToGroup(Tab tab, Group group) {
        tab.setGroupId(group.getId());
    }

    public void removeTabFromGroup(Tab tab) {
        tab.setGroupId(0);
    }
}
