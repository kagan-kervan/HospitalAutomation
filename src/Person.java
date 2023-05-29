package src;

abstract class Person {
    private String name;
    private String surname;
    private float height;
    private float weight;
    private int age;
    private String gender;
    private String bloodType;
    private int id;

    private Phone phone;

    public Person(String name, String surname, float height, float weight, int age, String gender, String bloodType, int id, Phone p) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
        this.id = id;
        this.phone = p;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }


    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", ID='" + id + '\'' +
                '}';
    }
}