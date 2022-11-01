package com.portfolio.fontana.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class People {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String lastname;
    
    @Size(min = 1, max = 100, message = "no cumple con la longitud")
    private String image;
       
}
