import com.github.cliftonlabs.json_simple.JsonException;

import java.io.IOException;
import java.util.List;

public class JsonParserTester{
    public static void main(String[] args) throws IOException, JsonException {
        List<Day> data = JsonParser.getAllDays();
        for(int i = 0; i < 10; i ++){
            System.out.println(data.get(i));
        }
    }
}

