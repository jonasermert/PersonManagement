package de.jonasermert.personmanagement;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Person {

    @Id
    public String id;

    public String name;
}
