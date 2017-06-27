package Monitoring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sve on 26.06.2017.
 */
public class LoadState implements State {

    @Override
    public void writeState(UI ui) {
        System.out.println("Загружаю...");

        // ui.setState(this);

    }

    @Override
    public void run(UI ui) {
        ui.startParse(ui);
    }

}



