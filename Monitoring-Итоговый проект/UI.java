package Monitoring;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sve on 26.06.2017.
 */
public class UI {
    private State state;

    Controller controller = Controller.getInstance();

    public UI() {
        this.state = state;
    }


    public State getState() {
        return state;
    }


    public void changeState(State newstate) {
        this.state = newstate;
    }




    public void start() {
        state.writeState(this);
        state.run(this);

    }

    public void downloadFile(String link, UI ui) {

        String pathFile;
        if(findFormat().equals("json")) {
            pathFile = "C://Users/Sve/IdeaProjects/Lesson13/src/new.json";
        }else{
            pathFile = "C://Users/Sve/IdeaProjects/Lesson13/src/new.xml";
        }

        try {
            Controller.downloadNew(link, pathFile, ui);


        } catch (MyException e) {
            if (e.getCode() == 100) {
                System.out.println("Произошла ошибка, данные не были обновлены");
            }
            ui.changeState(new FailureState());
        }

        state.writeState(this);
        state.run(this);

    }



    public void startParse(UI ui) {

        try {
            Controller.printSities("json");
            ui.changeState(new ReadyState());

        } catch (XMLStreamException e) {
            e.printStackTrace();
            ui.changeState(new FailureState());

        }
        state.writeState(this);
        state.run(this);

    }


    public String findFormat() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String link = scanner1.nextLine();

        String path = null;
        Pattern patFormat = Pattern.compile("\\.(\\w+)");
        Matcher matcher2 = patFormat.matcher(link);

        if(matcher2.find()) {
            if (matcher2.group(1).equals("xml")) {
                path = "C://Users/Sve/IdeaProjects/Lesson13/src/rad.xml";
            } else if (matcher2.group(1).equals("json")) {
                path = "C://Users/Sve/IdeaProjects/Lesson13/src/rad.json";
            } else {
                System.out.println("Некорректный формат файла");
            }
        }

        return path;
    }






}

