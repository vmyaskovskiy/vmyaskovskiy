package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.List;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        List<Address> res = new ArrayList<>();
        for (Profile profile: profiles) {
            res.add(profile.getAddress());
        }
        return res;
    }
}
