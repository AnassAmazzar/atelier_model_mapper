package ma.emsi.modelmapperdemo.dtos;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDtoNew {
    private String name;
    private String email;
    private String password;
}
