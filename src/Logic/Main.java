package Logic;

import Logic.*;

public class Main {
    public static void main(String[] args) {
        Browser browser = Browser.getInstance();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        browser.createTab(user1, "Tab 1");
        browser.createTab(user1, "Tab 2");
        browser.createTab(user2, "Tab 3");



        browser.createGroup(user1, "Group 1");
        browser.createGroup(user1, "Group 2");
        browser.createGroup(user2, "Group 3");

        browser.createTab(user1, "Tab 3");
        browser.addTabToGroup(user1.getTabs().get(0), user1.getGroups().get(0));
        browser.addTabToGroup(user1.getTabs().get(1), user1.getGroups().get(1));
        browser.addTabToGroup(user2.getTabs().get(0), user2.getGroups().get(0));

        System.out.println(user1.getName() + "'s groups and tabs:");
        System.out.println(user1);


    }
}
