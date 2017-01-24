package ua.training.model.dao;

import org.junit.*;
import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.util.List;

/**
 * Created by andrii on 19.01.17.
 */
//public class UserDaoTest {
//    //private DaoFactory daoFactory;
//    private UserDao userDao = DaoFactory.getInstance().createUserDao();
//    private DeveloperDao developerDao = DaoFactory.getInstance().createDeveloperDao();
//
//    @BeforeClass
//    public static void init() {
//        UserDao userDao = DaoFactory.getInstance().createUserDao();
//        DeveloperDao developerDao = DaoFactory.getInstance().createDeveloperDao();
//
//        List<Developer> developers = developerDao.findAll();
//        developers.stream().forEach(developer -> developerDao.delete(developer.getUser().getId()));
////
////        userDao.create(new User.Builder()
////                .setFirstName("Андрій")
////                .setMiddleName("Іванович")
////                .setLastName("Северін")
////                .setEmail("severinandrey1@i.ua")
////                .setPassword("andrii")
////                .setRole(Role.MANAGER)
////                .build());
////        userDao.create(new User.Builder()
////                .setFirstName("Andrii")
////                .setMiddleName("Іванович")
////                .setLastName("Severin")
////                .setEmail("severinandrey2@i.ua")
////                .setPassword("andrii")
////                .setRole(Role.CUSTOMER)
////                .build());
////        userDao.create(new User.Builder()
////                .setFirstName("Андрій")
////                .setMiddleName("Іванович")
////                .setLastName("Северін")
////                .setEmail("severinandrey3@i.ua")
////                .setPassword("andrii")
////                .setRole(Role.DEVELOPER)
////                .build());
//    }
//
//    @AfterClass
//    public static void close() {
//        UserDao userDao = DaoFactory.getInstance().createUserDao();
//        List<User> users = userDao.findAll();
//        users.stream().forEach(user -> userDao.delete(user.getId()));
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//
//    }
//
//    @Test
//    public void findByNameTest() {
//        List<User> users = userDao.findAll();
//        for (User user : users){
//            System.out.println(user);
//        }
//        System.out.println();
//    }
//
//    @Test
//    public void findByQualificationTest() {
//
//    }
//
//    @Test
//    public void findByEmailTest() {
//
//    }
//
//    @Test
//    public void loginTest() {
//
//    }
//
//    @Test
//    public void getUserByEmailTest() {
//
//    }
//
//    @Test
//    public void findTest() {
////        Developer developer = new Developer(
////                userDao.findByEmail("severinandrey2@i.ua").orElse(null),
////                Qualification.MIDDLE,
////                true
////        );
////        developerDao.create(developer);
//    }
//
//    @Test
//    public void findAllTest() {
////        User new_user = new User.Builder()
////                .setFirstName("Андрій")
////                .setMiddleName("Іванович")
////                .setLastName("Северін")
////                .setEmail("severinandrey@i.ua")
////                .setPassword("andrii")
////                .setRole(Role.DEVELOPER)
////                .build();
////        Developer developer = new Developer(new_user,
////                Qualification.MIDDLE, true);
////        userDao.create(new_user);
//        List<Developer> developers = developerDao.findAll();
//        for (Developer developer : developers){
//            System.out.println(developer);
//        }
//        System.out.println();
//    }
//
//    @Test
//    public void create() {
//        userDao.delete(1);
//        User new_user = new User.Builder()
//                .setFirstName("Андрій")
//                .setMiddleName("Іванович")
//                .setLastName("Северін")
//                .setEmail("severinandrey2@i.ua")
//                .setPassword("andrii")
//                .setRole(Role.DEVELOPER)
//                .build();
//        userDao.create(new_user);
//
//        Assert.assertNotNull(new_user.getId());
//        System.out.println(new_user.getId());
//    }
//
//    @Test
//    public void updateTest() {
//
//    }
//
//    @Test
//    public void deleteTest() {
//
//    }
//}
