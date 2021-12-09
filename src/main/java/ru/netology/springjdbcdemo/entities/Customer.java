package ru.netology.springjdbcdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(columnDefinition = "int check ( age > -1 )")
    private int age;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "customer",
            cascade = CascadeType.ALL)
    private List<Order> orders;
}
