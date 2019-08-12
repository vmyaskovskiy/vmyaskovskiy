package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.Address;
import ru.job4j.lyambda.Profile;
import ru.job4j.lyambda.Profiles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

public class TestProfiles {
    @Test
    public void testAddress() {
        List<Profile> profExp = List.of(
                new Profile(new Address("Livov", "street", 2, 1)),
                new Profile(new Address("Peter", "street2", 3, 4)),
                new Profile(new Address("Peter", "street2", 3, 4)),
                new Profile(new Address("Arbat", "street2", 3, 4))
        );
        Profiles profiles = new Profiles();
        List<Address> res = profiles.collect(profExp);
        List<Address> res1 = profExp.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
        assertThat(res.size(), Is.is(4));
        assertThat(res1.size(), Is.is(4));
        System.out.println(res1);
        List<Address> res4 = profExp.stream().
                map(profile -> profile.getAddress()).
                sorted(Comparator.comparing(Address -> Address.getCity())).
                distinct().
                collect(Collectors.toList());
        System.out.println(res4);
        List<Address> res3 = profExp.stream().
                map(Profile::getAddress).
                sorted().
                distinct().collect(Collectors.toList());
        System.out.println(res3);
        assertThat(res4.size(), Is.is(3));
    }
}
