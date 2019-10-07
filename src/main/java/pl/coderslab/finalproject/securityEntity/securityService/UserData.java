package pl.coderslab.finalproject.securityEntity.securityService;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserData {

    @Email
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String password2;
    @Size(min = 2,max = 40)
    private String name;
    @Size(min = 2,max = 40)
    private String surname;


}
