package com.uws.secureprogramming.dataLeak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {

    private UserDatabase userDatabase;
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        userDatabase = new UserDatabase();
        // Add example users (Disney characters)
        userDatabase.addUser(new User("mickey", "mm@disney.com",	 "mouse123"));
        userDatabase.addUser(new User("donald", "dd@disney.com", "duck456"));
        userDatabase.addUser(new User("goofy", "goof@disney.com", "good123"));
        userDatabase.addUser(new User("minnie", "mm01@disney.com", "minnie321"));
        dbConnection = new DatabaseConnection(userDatabase);
    }

    //TODO Follow excercise to shoe exception handling vulnerabilities
    
    @Test
    void testConnectWithNullUsername() {
        dbConnection.connectToDatabase(null, "password");
        // Expect error message and stack trace printed
    }

    @Test
    void testConnectWithNullPassword() {
        dbConnection.connectToDatabase("mickey", null);
        // Expect error message and stack trace printed
    }

    @Test
    void testUserNotFoundOrIncorrectPassword() {
        dbConnection.connectToDatabase("pluto", "dog123");
        dbConnection.connectToDatabase("donald", "wrongpass");
        // Expect error message and stack trace printed
    }

    @Test
    void testSuccessfulConnection() {
        dbConnection.connectToDatabase("goofy", "goof789");
        dbConnection.connectToDatabase("minnie", "minnie321");
        // Expect successful connection message printed
    }
}
