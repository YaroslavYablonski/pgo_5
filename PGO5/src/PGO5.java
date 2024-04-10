import java.util.ArrayList;

public class PGO5 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();


        Developer dev = new Developer("John", "Doe", "New York", "john@doe.com", "123456789", 2020);
        Technology t = new Technology("Java", 800);
        dev.addTechnology(t);
        employees.add(dev);


        Tester tester = new Tester("Jane", "Smith", "Los Angeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);


        Manager manager = new Manager("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        Goal goal = new Goal(2010, 10, 15, "Implementing FB login", 1000);
        manager.addGoal(goal);
        employees.add(manager);


        int kwota = 0;
        for (Employee employee : employees) {
            kwota += employee.calculateSalary();
        }

        System.out.println("Total amount to be paid this month: usd" + kwota);
    }
}

class Employee {
    protected String imie;
    protected String nazwisko;
    protected String adres;
    protected String email;
    protected String pesel;
    protected int RokZat;

    public Employee(String imie, String nazwisko, String adres, String email, String pesel, int RokZat) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.email = email;
        this.pesel = pesel;
        this.RokZat = RokZat;
    }

    public int calculateSalary() {
        int baseSalary = 3000 + (2024 - RokZat) * 1000;
        return baseSalary;
    }
}

class Developer extends Employee {
    private ArrayList<Technology> technologies = new ArrayList<>();

    public Developer(String imie, String nazwisko, String adres, String email, String pesel, int RokZat) {
        super(imie, nazwisko, adres, email, pesel, RokZat);
    }

    public void addTechnology(Technology tech) {
        technologies.add(tech);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        for (Technology tech : technologies) {
            baseSalary += tech.getBonus();
        }
        return baseSalary;
    }
}

class Tester extends Employee {
    private ArrayList<String> testTypes = new ArrayList<>();

    public Tester(String imie, String nazwisko, String adres, String email, String pesel, int RokZat) {
        super(imie, nazwisko, adres, email, pesel, RokZat);
    }

    public void addTestType(String testType) {
        testTypes.add(testType);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        baseSalary += testTypes.size() * 300;
        return baseSalary;
    }
}

class Manager extends Employee {
    private ArrayList<Goal> goals = new ArrayList<>();

    public Manager(String imie, String nazwisko, String adres, String email, String pesel, int RokZat) {
        super(imie, nazwisko, adres, email, pesel, RokZat);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        for (Goal goal : goals) {
            if (goal.isAchieved()) {
                baseSalary += goal.getBonus();
            }
        }
        return baseSalary;
    }
}

class Technology {
    private String imie;
    private int bonus;

    public Technology(String imie, int bonus) {
        this.imie = imie;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

class Goal {
    private int rok;
    private int miesiac;
    private int dzien;
    private String nazwa;
    private int bonus;

    public Goal(int rok, int miesiac, int dzien, String nazwa, int bonus) {
        this.rok = rok;
        this.miesiac = miesiac;
        this.dzien = dzien;
        this.nazwa = nazwa;
        this.bonus = bonus;
    }

    public boolean isAchieved() {
        // Implement your logic to check if the goal is achieved
        return false;
    }

    public int getBonus() {
        return bonus;
    }
}