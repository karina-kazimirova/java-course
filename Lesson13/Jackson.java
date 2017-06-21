/**
 * Created by Sve on 20.06.2017.
 */

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

public class Jackson {
    public static void main(String[] args) throws IOException {

        Root root = parseJackson("C://Users/Sve/IdeaProjects/Lesson13/test.json");
        System.out.println(root.toString());
    }

    public static Root parseJackson(String path) {


        Root root = null;
        try {
            ObjectMapper mapper = new ObjectMapper();

            File file = new File(path);

            root = mapper.readValue(file, Root.class);

        } catch (Exception e) {
            System.out.println(e);
        }

        return root;
    }


}


