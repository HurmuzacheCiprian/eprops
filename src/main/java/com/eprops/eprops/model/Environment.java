package com.eprops.eprops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Environment {

    @Id
    @GeneratedValue
    private Long environment;

    @Column(name = "name")
    private String name;

}
