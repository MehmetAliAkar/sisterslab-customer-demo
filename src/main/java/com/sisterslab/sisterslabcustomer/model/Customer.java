package com.sisterslab.sisterslabcustomer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //DB'de tablo yaratır
@Table(name = "Customer") // DB'de yarattığımız tablonun ismini belirleriz
@Getter
@Setter
public class Customer {
    @Id //Tabloya primary key ekledik
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Primary keyin artış stratejisini belirledik
    private Long id;
    private String first_name;
    private String last_name;
    private String nick_name;
    private String e_mail;
}
