public class User {  // класс пользователь
    private static long userCount; // количество пользователей

    private long id;        // id
    private String login;   // логин
    private String password; // пароль
    private String surname;  // фамилия
    private String firstName; // имя

    static {
        userCount = 0;
    }

    public User() {              // конструктор по умолчанию
        userCount += 1;
        this.setId(userCount);
    }

    public User(String login, String password, String surname, String firstName) { // конструктор с параметрами
        userCount += 1;
        this.setId(userCount);
        this.setLogin(login);
        this.setPassword(password);
        this.setSurname(surname);
        this.setFirstName(firstName);
    }

    public long getId() {     // получить ID
        return id;
    }

    private void setId(long id) {  // установить ID - метод недоступен вне класса
        this.id = id;
    }

    public String getLogin() {   // получить логин
        return login;
    }

    public void setLogin(String login) {  // установить логин
        this.login = login;
    }

    public String getPassword() {    // получить пароль
        return password;
    }

    public void setPassword(String password) {   // установить пароль
        this.password = password;
    }

    public String getSurname() {    // получить фамилию
        return surname;
    }

    public void setSurname(String surname) {   // установить фамилию
        this.surname = surname;
    }

    public String getFirstName() {     // получить имя
        return firstName;
    }

    public void setFirstName(String firstName) {   // установить имя
        this.firstName = firstName;
    }
}
