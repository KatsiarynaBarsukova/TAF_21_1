package tests.db;

import baseEntities.BaseApiTest;
import dbEntities.CustomersTable;
import dbServies.CustomerService;
import models.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleDBTest extends BaseApiTest {

    @Test
    public void simpleDBTest() {
        CustomersTable customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createCustomersTable();

        customersTable.addCustomer(Customer.builder()
                .firstname("Иван")
                .lastName("Иванов")
                .email("iviv@test.com")
                .age(32)
                .build());

        customersTable.addCustomer(Customer.builder()
                .firstname("Петр")
                .lastName("Петров")
                .email("pepe@test.com")
                .age(28)
                .build());

        customersTable.addCustomer(Customer.builder()
                .firstname("Марина")
                .lastName("Стасевич")
                .email("ms@test.com")
                .age(23)
                .build());

        ResultSet rs = customersTable.getCustomer();

        try {
            while (rs.next()) {
                String userid = rs.getString("ID");
                String firsname = rs.getString("firsname");
                String Lastname = rs.getString("Lastname");
                int age = rs.getInt("age");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        @Test
        public void hibernateTest () {
            CustomerService customerService = new CustomerService();
            Customer customer = new CustomerService("Ivan", "Grigoriev", "qrtest@test.com", 30);

            List<Customer> customerList = customerService.findAllUser();
            for (Customer user : customerList) {
                System.out.println(user.toString());
            }

        }
    }
}