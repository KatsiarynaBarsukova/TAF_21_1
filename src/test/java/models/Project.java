package models;

public class Project {
    private String name;
    private String description;
    private int type;
    private boolean showAnon;
    private boolean access;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isShowAnon() {
        return showAnon;
    }

    public void setShowAnon(boolean showAnon) {
        this.showAnon = showAnon;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
