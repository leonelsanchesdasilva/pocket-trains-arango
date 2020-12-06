package leonel.pockettrainsarango.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import leonel.pockettrainsarango.model.CargoItem;
import leonel.pockettrainsarango.model.City;
import leonel.pockettrainsarango.model.Route;

import java.io.IOException;
import java.util.Optional;

public class CitySerializer extends JsonSerializer<City> {
    @Override
    public void serialize(City city, JsonGenerator jsonGenerator, SerializerProvider serializers)
            throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", city.getId());
        jsonGenerator.writeStringField("name", city.getName());

        jsonGenerator.writeArrayFieldStart("routes");
        for (Route routeFrom: city.getRoutesFrom()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField(routeFrom.getTo().getName(), Optional.of(routeFrom.getDistance()).orElseGet(() -> 0));
            jsonGenerator.writeEndObject();
        }

        for (Route routeTo: city.getRoutesTo()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField(routeTo.getFrom().getName(), Optional.of(routeTo.getDistance()).orElseGet(() -> 0));
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeArrayFieldStart("connectedCities");
        for (City connectedCity: city.getConnectedCities()) {
            jsonGenerator.writeString(connectedCity.getName());
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeArrayFieldStart("cargoItems");
        for (CargoItem cargoItem: city.getCargoItems()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("description", cargoItem.getDescription());
            jsonGenerator.writeNumberField("slotSize", cargoItem.getSlotSize());
            jsonGenerator.writeNumberField("value", cargoItem.getValue());
            jsonGenerator.writeStringField("destination", cargoItem.getDestination().getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
