package petsClinic;

import java.util.Arrays;

public class Pet {
    private String name;
    private String type;
    private String birthday;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public Pet(String name, String type, String birthday) {
        this.name = name;
        this.type = type;
        this.birthday = birthday;
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

    private void setType(String type) {
        this.type = type;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String date) {
        this.birthday = date;
    }


    public void editPet(Pet pet){
        setName(pet.getName());
        setType(pet.getType());
        setBirthday(pet.getBirthday());
    }

    @Override
    public String toString() {
        return name + "(" + type + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return (name.equalsIgnoreCase(((Pet)obj).getName()) && type.equalsIgnoreCase(((Pet)obj).getType()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Arrays.hashCode(type.toCharArray());
        return 31 * result + Arrays.hashCode(name.toCharArray());
    }
}
