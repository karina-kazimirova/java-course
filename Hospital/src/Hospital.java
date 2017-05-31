import java.util.Scanner;

/**
 * Created by Sve on 30.05.2017.
 */
public class Hospital {

    public static void main(String[] args) {

        Patient[] patient = new Patient[5];

        // Создаем объекты и заполняем
        for (int i = 0; i < patient.length; i++) {
            patient[i] = new Patient();
            addName(patient, i);
            addAge(patient, i);
            addRoomNumer(patient, i);
            addDiagnosis(patient, i);
            addIsTreat(patient, i);

        }

        Patient.hospitallName = "BotkinsHospital";


        printAll(patient);

        searchPatient(patient);

        searchAgePatient(patient);


    }

// Не объединяю все методы в один, чтобы было проще ими управлять если нужно что-то изменить


    // Назначаем пациентам Фамилии, введённые с клавиатуры
    public static void addName(Patient[] patient, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию пациента №" + (x + 1) + " ");
        patient[x].name = scanner.nextLine();


    }

    // Назначаем пациентам возраст, введённый с клавиатуры
    public static void addAge(Patient[] patient, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст пациента №" + (x + 1) + " ");
        patient[x].age = scanner.nextInt();


    }

    // Назначаем пациентам номер палаты, введённый с клавиатуры
    public static void addRoomNumer(Patient[] patient, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер палаты пациента №" + (x + 1) + " ");
        patient[x].roomNumber = scanner.nextInt();


    }

    // Назначаем пациентам диагноз, введённый с клавиатуры
    public static void addDiagnosis(Patient[] patient, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите диагноз пациента №" + (x + 1) + " ");
        patient[x].diagnosis = scanner.nextLine();

    }

    // Проверяем получают ли лечение
    public static boolean addIsTreat(Patient[] patient, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пациент № " + (x + 1) + " получает лечение?");
        String s = scanner.nextLine();

        if (s.equals("да")) {
            patient[x].isTreated = true;
        } else
            patient[x].isTreated = false;


        return patient[x].isTreated;

    }

    // Печатаем всех пациентов
    public static void printAll(Patient[] patient) {

        String treat;
        for (int i = 0; i < patient.length; i++) {
            if (patient[i].isTreated == true) {
                treat = "Пациент получает лечение";
            }
            else {
                treat = "Пациент не получает лечения";
            }
            System.out.println(Patient.hospitallName + " Пациент " + patient[i].name + ", " + "Возраст = " + patient[i].age + " лет, " + "Номер палаты " + patient[i].roomNumber + ", " + "Диагноз пациента: " + patient[i].diagnosis + ", " + treat);
        }

    }

    // Поиск по фамилии
    public static void searchPatient(Patient[] patient){

        String name;
        int count = 0;
        String[] searchResult = new String[patient.length];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Найти пациента по фамилии");
        System.out.println("Введите фамилию:");
        name = scanner.nextLine();

        for(int i = 0; i < patient.length; i++){

            if(name.equals(patient[i].name)){
                count++;
                searchResult[i] = patient[i].name;
            }
        }

        System.out.println("Найдено: " + count);
        for(int i = 0; i < searchResult.length; i++){
            if(searchResult[i] != null){
                System.out.println(searchResult[i]);
            }
        }
    }

    // Поиск по возрасту
    public static void searchAgePatient(Patient[] patient){

        int age;
        int count = 0;
        String allNames = "Cписок найденных пациентов: " + "\n";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Найти пациента по возрасту");
        System.out.println("Введите возраст:");
        age = scanner.nextInt();

        for(int i = 0; i < patient.length; i++){

            if(age == (patient[i].age)){
                count++;
                allNames += "Фамилия: " + patient[i].name + ", " + "Возраст: " + patient[i].age + "; " + "\n";

            }
        }

        System.out.println("Найдено: " + count);
        System.out.println(allNames);

    }
}
