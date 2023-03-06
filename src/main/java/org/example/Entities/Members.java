package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Members {
    private String Id;
    private String name;
    private String late_fee;
    private String street_address;
    private String email;
}
