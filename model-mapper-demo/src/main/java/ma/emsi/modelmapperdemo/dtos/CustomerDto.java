package ma.emsi.modelmapperdemo.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private String name;
    private String email;
}
