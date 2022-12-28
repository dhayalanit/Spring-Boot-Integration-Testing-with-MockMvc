package com.dhayalanit.spring_boot_integration_testing_with_mockmvc.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="batteries")
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String postcode;

    @Column
    @NonNull
    private int capacity;

    public Battery(String s, String s1, int i) {
    }
}
