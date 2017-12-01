package spring.boot.security.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user")
@Entity
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String role;
}

