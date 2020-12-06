package leonel.pockettrainsarango.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import leonel.pockettrainsarango.model.Route;

import java.io.IOException;

public class RouteSerializer extends JsonSerializer<Route> {
    @Override
    public void serialize(Route route, JsonGenerator jsonGenerator, SerializerProvider serializers)
            throws IOException {

        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", route.getId());
        jsonGenerator.writeStringField("from", route.getFrom().getName());
        jsonGenerator.writeStringField("to", route.getTo().getName());
        jsonGenerator.writeNumberField("distance", route.getDistance());

        jsonGenerator.writeEndObject();
    }
}
