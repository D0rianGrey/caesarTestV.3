package softserve.academy.models;

public class UserDataProvider {

    // COMMON USE (Currently present in AdminPanel)************************************************************************
    public static final User admin = new User ("Oleg", "Tabakov", Role.ADMIN.getValue(),
            Location.SOFIA.getValue(), "", "Shelenberg", "1234");

    public static final User teacher = new User("Vladislav", "Tikhonov", Role.TEACHER.getValue(),
                            Location.RIVNE.getValue(), "", "Shtirlits", "1234");

    public static final User coordinator = new User("Leonid", "Bronevoy", Role.COORDINATOR.getValue(),
                            Location.KYIV.getValue(), "", "Muler", "1234");

    public static final User admin1 = new User ("Ekaterina", "Gradova", Role.ADMIN.getValue(),
            Location.IVANO_FRANKIVSK.getValue(), "", "radistka", "ket");

    public static final User teacher1 = new User("Evgeniy", "Evstigneev", Role.TEACHER.getValue(),
            Location.LVIV.getValue(), "", "professor", "1234");

    public static final User coordinator1 = new User("Rostislav", "Plyatt", Role.COORDINATOR.getValue(),
            Location.CHERNIVTSY.getValue(), "", "pastor", "1234");
    //Admin TESTS ONLY *******************************************************************************************************************
    public static final User adminAdmin = new User("Oleg", "Yankovskiy", Role.ADMIN.getValue(),
            Location.IVANO_FRANKIVSK.getValue(), "", "Baron", "1234");
    public static final User adminTeacher = new User("Mikhail", "Kononov", Role.TEACHER.getValue(),
            Location.SOFIA.getValue(), "", "Nestor", "1234");
    public static final User adminCoord = new User("Evgeniy", "Leonov", Role.COORDINATOR.getValue(),
            Location.DNIPRO.getValue(), "", "Dotcent", "1234");
    public static final User agent007 = new User("James", "Bond", Role.COORDINATOR.getValue(),
            Location.KYIV.getValue(), "", "agent", "007");
    //TEST 107 ONLY********************************************************************************************************
    public static User teacher107 = new User("Alex", "Teacher", Role.TEACHER.getValue(),
            Location.DNIPRO.getValue(), "", "teach", "1234");
    public static User coordinator107 = new User ("Denys", "Coordinator", Role.COORDINATOR.getValue(),
            Location.KYIV.getValue(), "", "coord", "1234");
    public static final User admin107 = new User ("Borys", "Admin", Role.ADMIN.getValue(),
            Location.LVIV.getValue(), "", "admin", "1234");
    // ******************************************************************************************************************
}
