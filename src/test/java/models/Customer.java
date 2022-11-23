package models;


import jakarta.persistence.*;

public class Customer {
@Entity
    @Table(name = "Customer")
    public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "FirstName")
    }
}
