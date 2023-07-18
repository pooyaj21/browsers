package Logic;

public class Group {
   private String name;
   private final int id;
   private static int counter=0;

    public Group(String name) {
        this.name = name;
        this.id = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
