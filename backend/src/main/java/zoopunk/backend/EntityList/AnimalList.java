package zoopunk.backend.EntityList;


import zoopunk.backend.Entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalList {
    private List<Animal> animals;
    private List<String> names;
    public AnimalList() {
        animals = null;
        names = null;
    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
