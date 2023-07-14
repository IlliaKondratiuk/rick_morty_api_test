import com.fasterxml.jackson.core.JsonProcessingException;
import jsonobjects.Episodes;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import query.QueryClass;


public class Episodetest {
    Episodes epis;
    @Test
    public void printing() {
        ObjectMapper om = new ObjectMapper();
        try {
            String url = "https://rickandmortyapi.com/api/episode";
            epis = om.readValue(QueryClass.getjson(url), Episodes.class);
            for (; epis.info.next != null; url = epis.info.next) {
                epis = om.readValue(QueryClass.getjson(url), Episodes.class);
                for (int i = 0; i < epis.results.size(); i++) {
                    System.out.println("Episode name: " + epis.results.get(i).name);
                    System.out.println("Air date: " + epis.results.get(i).air_date + '\n');
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
