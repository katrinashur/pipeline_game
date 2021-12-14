package main.model;

import jdk.jfr.Event;

import java.util.List;

/**
 * Created by @author Шурлаева Екатерина on 13.12.2021
 */
public interface Player {

    void fireEvent(Event event);

    void subscribe(Subscriber subscriber);

}
