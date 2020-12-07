package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Ref;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Document(value="trainParts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainPart {

    @Id
    protected String id;

    @Ref
    protected TrainTechnology trainTechnology;
}
