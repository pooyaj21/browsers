package Logic;

public class Tab {
    private String name;
    private String url;
    private int groupId;

    public Tab(String name) {
        this.name = name;
        this.groupId = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean haveGroup(){
        return groupId>(-1);
    }
}
