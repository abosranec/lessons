package petsClinic.pets;

import java.util.Arrays;

public abstract class Pet {
    private String name;
    private String type;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Pet(Pet pet, String type) {
        this.name = pet.getName();
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + "(" + type + ") + " + this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (name.equals(((Pet)obj).getName()) && type.equals(((Pet)obj).getType()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Arrays.hashCode(type.toCharArray());
        return 31 * result + Arrays.hashCode(name.toCharArray());
    }
}
