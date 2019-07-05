package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.Address;
import ru.job4j.lyambda.Profile;
import ru.job4j.lyambda.Profiles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

public class TestProfiles {
    @Test
    public void testAddress() {
        Profile prof1 = new Profile(new Address("Livov", "street", 2, 1));
        Profile prof2 = new Profile(new Address("Peter", "street2", 3, 4));

        List<Profile> profAll = Arrays.asList(
                prof1,
                prof2
        );
        Profiles profiles = new Profiles();
        List<Address> res = profiles.collect(profAll);
        List<Address> res1 = profAll.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
        assertThat(res.size(), Is.is(2));
        assertThat(res1.size(), Is.is(2));
    }
}
