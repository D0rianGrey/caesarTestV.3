package softserve.academy.models;

public class Group {
    String name;
    Location location;
    boolean budgetOwner;
    Direction direction;
    String startDate;
    String finishDate;
    String teacher;
    String expert;
    GroupStage stage;

    public Group (){};
    public Group (String name,
                  Location location,
                  boolean budgetOwner,
                  Direction direction,
                  String startDate,
                  String finishDate,
                  String teacher,
                  String expert,
                  GroupStage stage){
        this.name=name;
        this.location=location;
        this.budgetOwner=budgetOwner;
        this.direction=direction;
        this.startDate=startDate;
        this.finishDate=finishDate;
        this.teacher=teacher;
        this.expert=expert;
        this.stage=stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isBudgetOwner() {
        return budgetOwner;
    }

    public void setBudgetOwner(boolean budgetOwner) {
        this.budgetOwner = budgetOwner;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public GroupStage getStage() {
        return stage;
    }

    public void setStage(GroupStage stage) {
        this.stage = stage;
    }

    //get String as parameter and convert it to ENUM
    public void setStage(String stageStr) {
        GroupStage tempEnum=null;
        for (GroupStage st:GroupStage.values()) {
            if (st.toString().equals(stageStr)){
                tempEnum = st;
                break;
            }
        }
        this.stage = tempEnum;
    }

    //get String as parameter and convert it to ENUM
    public void setDirection(String directionStr) {
        Direction tempEnum=null;
        for (Direction st:Direction.values()) {
            if (st.toString().equals(directionStr)){
                tempEnum = st;
                break;
            }
        }
        this.direction = tempEnum;
    }

    //get String as parameter and convert it to ENUM
    public void setLocation(String locationStr) {
        Location tempEnum=null;
        for (Location st:Location.values()) {
            if (st.toString().equals(locationStr)){
                tempEnum = st;
                break;
            }
        }
        this.location = tempEnum;
    }

    @Override //toString just for "On Fly" debug
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", budgetOwner=" + budgetOwner +
                ", direction=" + direction +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", teacher='" + teacher + '\'' +
                ", expert='" + expert + '\'' +
                ", stage=" + stage +
                '}';
    }
    //****************************************************************************************************************

    String location1;

    String direction1;

    String stage1;


    public Group(String name,
                 String location1,
                 boolean budgetOwner,
                 String direction1,
                 String startDate,
                 String finishDate,
                 String teacher,
                 String expert,
                 String stage1) {
        this.name = name;
        this.location1 = location1;
        this.budgetOwner = budgetOwner;
        this.direction1 = direction1;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.teacher = teacher;
        this.expert = expert;
        this.stage1 = stage1;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getDirection1() {
        return direction1;
    }

    public void setDirection1(String direction1) {
        this.direction1 = direction1;
    }


    public String getStage1() {
        return stage1;
    }

    public void setStage1(String stage1) {
        this.stage1 = stage1;
    }
}
