package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import leonel.pockettrainsarango.serialization.RouteSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Edge("routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = RouteSerializer.class)
public class Route {

    @Id
    private String id;

    @From
    private City from;

    @To
    private City to;

    private Integer distance;
}
