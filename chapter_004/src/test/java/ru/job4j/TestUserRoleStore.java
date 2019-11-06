package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.Role;
import ru.job4j.lyambda.RoleStore;
import ru.job4j.lyambda.User;
import ru.job4j.lyambda.UserStory;

import static org.junit.Assert.assertThat;

public class TestUserRoleStore {
    @Test
    public void userStore() {
        User user = new User("1", "Slava");
        User user1 = new User("1", "Petr");
        User user2 = new User("2", "Pavel");
        UserStory userStory = new UserStory(6);
        userStory.add(user);
        assertThat(userStory.findById("1").getId(), Is.is("1"));
        userStory.replace("1", user1);
        User user3 = (User) userStory.findById("1");
        assertThat(user3.getName(), Is.is("Petr"));
        userStory.add(user2);
        assertThat(userStory.findById("2").getId(), Is.is("2"));
        User user4 = (User) userStory.findById("2");
        assertThat(user4.getName(), Is.is("Pavel"));
    }
    @Test
    public void roleStore() {
        Role role = new Role("1", "Worker");
        Role role1 = new Role("1", "Bilder");
        Role role2 = new Role("2", "Manager");
        RoleStore roleStore = new RoleStore(6);
        roleStore.add(role);
        assertThat(roleStore.findById("1").getId(), Is.is("1"));
        roleStore.replace("1", role1);
        Role role3 = (Role) roleStore.findById("1");
        assertThat(role3.getDescription(), Is.is("Bilder"));
        roleStore.add(role2);
        assertThat(roleStore.findById("2").getId(), Is.is("2"));
        Role role4 = (Role) roleStore.findById("2");
        assertThat(role4.getDescription(), Is.is("Manager"));
    }
}
