package leonel.pockettrainsarango.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoutePostDto {

    private String from;
    private String to;
    private Integer distance;
}
