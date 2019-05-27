package softserve.academy.models;

public class Student {

    private String groupID;
    private String name;
    private String lastName;
    private EnglishLevel englishLevel;
    private String cv;
    private int incomingTest;
    private int entryScore;
    private Expert approvedBy;
    private String photo;

    public Student() {
    }

    public Student(
                   String name,
                   String lastName,
                   int incomingTest,
                   int entryScore){
        this.name = name;
        this.lastName = lastName;
        this.incomingTest = incomingTest;
        this.entryScore =  entryScore;
    };

    public void setAllStudentRequiredFields(String name,
                                            String lastName,
                                            int incomingTest,
                                            int entryScore) {

        this.name = name;
        this.lastName = lastName;
        this.incomingTest = incomingTest;
        this.entryScore =  entryScore;
    }

// THIS method for AdminPanel without  int incomingTest!!!
    public void setAllFields(String groupID,
                             String name,
                             String lastName,
                             EnglishLevel englishLevel,
                             int entryScore,
                             Expert approvedBy) {

        this.groupID=groupID;
        this.name = name;
        this.lastName = lastName;
        this.englishLevel =  englishLevel;
        this.entryScore =  entryScore;
        this.approvedBy =  approvedBy;

    }


    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getIncomingTest() {
        return incomingTest;
    }

    public void setIncomingTest(int incomingTest) {
        this.incomingTest = incomingTest;
    }

    public int getEntryScore() {
        return entryScore;
    }

    public void setEntryScore(int entryScore) {
        this.entryScore = entryScore;
    }

    public Expert getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Expert approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}