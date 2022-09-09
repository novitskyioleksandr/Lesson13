package Lesson13;

import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String URI_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_SITE = "https://jsonplaceholder.typicode.com/";


    public static void main(String[] args) throws IOException, InterruptedException {

        User user = new User();
        user.setId(1);
        user.setName("Oleksandr Novitskyi");
        user.setUserName("Oleksandr");
        user.setEmail("novitskyi.oleksandr@gmail.com");
        user.setAddress("Street", "suite", "Dnipro", "49080", "48°28′00", "35°01′05");
        user.setPhone("00-123456789");
        user.setWebsite("novitskyi");
        user.setCompany("nameCompany", "catchPhrase", "bs");

        User user1 = HttpUtil.createUser(URI.create(URI_USERS), user);

        System.out.println("\n----------\n");
        System.out.println(user1);

        System.out.println("\n----------\n");
        user1.setName("Mark");
        User user2 = HttpUtil.updateUser(URI.create(URI_USERS), user1);
        System.out.println(user2);

        System.out.println("\n----------\n");
        System.out.println(HttpUtil.deleteUser(URI.create(URI_USERS), user2));

        System.out.println("\n----------\n");
        System.out.println(HttpUtil.getAllUsers(URI.create(URI_USERS)).toString());

        System.out.println("\n----------\n");
        User user5 = HttpUtil.getUserWithId(URI.create(URI_USERS), 1);
        System.out.println(user5);

        System.out.println("\n----------\n");
        System.out.println(HttpUtil.getUserWithUsername(URI.create(URI_USERS), "Julia").toString());

        System.out.println("\n----------\n");
        HttpUtil.getAllCommentsWithLastPost(URI.create(URI_SITE));

        System.out.println("\n----------\n");
        HttpUtil.printAllUserTask(URI.create(URI_USERS));
    }
}