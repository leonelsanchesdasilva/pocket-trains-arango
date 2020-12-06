package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.Relations;
import com.arangodb.springframework.annotation.To;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import leonel.pockettrainsarango.serialization.CitySerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Document(value = "cities")
@Data
@NoArgsConstructor
@JsonSerialize(using = CitySerializer.class)
public class City {

    @Id
    private String id;
    private String name;

    @From(lazy = true)
    private Collection<Route> routesFrom;

    @To(lazy = true)
    private Collection<Route> routesTo;

    @From(lazy = true)
    private Collection<CargoItem> cargoItems;

    @Relations(edges = Route.class, direction = Relations.Direction.ANY, lazy = true)
    private Collection<City> connectedCities;

    public City(String name) {
        this.name = name;
    }
}
