import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JsonParser{
    public static List<Day>  getAllDays() throws IOException, JsonException{
        FileReader fileReader = new FileReader(("CovidTrackingData.json"));
        JsonArray objects = Jsoner.deserializeMany(fileReader);
        Mapper mapper = new DozerBeanMapper();
        JsonArray o = (JsonArray) objects.get(0);
        List<Day> collect = o.stream().map(x -> mapper.map(x, Day.class)).collect(Collectors.toList());
        return collect;
    }
}