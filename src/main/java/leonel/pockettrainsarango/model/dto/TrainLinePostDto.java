package leonel.pockettrainsarango.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TrainLinePostDto {

    private String name;
    private String trainTechnology;
    private List<TrainRouteDto> trainRoutes;
}
