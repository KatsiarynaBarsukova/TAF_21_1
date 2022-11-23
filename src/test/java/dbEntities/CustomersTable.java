package dbEntities;

import models.Customer;
import services.DataBaseService;

import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class CustomersTable {
    private DataBaseService dataBaseService;

    public CustomersTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void dropTable() {
        System.out.println("Удаляем customers таблицу");
        String dropTableCustomersSQL = "DROP TABLE Customers;";

        dataBaseService.executeSQL(dropTableCustomersSQL);
    }

    public void createCustomersTable() {
        System.out.println("Создаем customers таблицу");

        String createTableSQL = "CREATE TABLE Customers (" +
                "ID SERIAL PRIMARY KEY, " +
                "FirstName CHARACTER VARYING(30), " +
                "LastName CHARACTER VARYING(30), " +
                "Email CHARACTER VARYING(30), " +
                "Age INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void addCustomer(Customer customer) {
        String insertTableSQL = "INSERT INTO public.Customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customer.getFirstname() + "', '" + customer.getLastName() +
                "', '" + customer.getEmail() + "', " + customer.getAge() + ");";

        dataBaseService.executeSQL(insertTableSQL);
    }
    public ResultSet getCustomer(){

        return dataBaseService.executeQuery(selectSQR);
    }
}
