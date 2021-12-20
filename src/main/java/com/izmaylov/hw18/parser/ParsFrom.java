package com.izmaylov.hw18.parser;

import com.izmaylov.hw18.model.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsFrom {
    private static Box box = new Box();
    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private static BufferedReader createReader(String string) {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(classLoader.getResourceAsStream(string))));
    }

    public static Box xml(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Pattern fromPattern;
        Matcher matcher;
        BufferedReader in = createReader(string);
        String temp;
        try {
            while ((temp = in.readLine()) != null){
                fromPattern = Pattern.compile(".*from=\"(.*?)\".*");
                matcher = fromPattern.matcher(temp);
                while(matcher.find()){
                        box.setFrom(matcher.group(1));
                }
                fromPattern = Pattern.compile(".*material=\"(.*?)\".*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.setMaterial(matcher.group(1));
                }
                fromPattern = Pattern.compile("<color>(.*)<.color>*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.setColor(matcher.group(1));
                }
                fromPattern = Pattern.compile(".*unit=\"(.*?)\".*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getMaxLiftingCapacity().setUnit(matcher.group(1));
                }

                fromPattern = Pattern.compile("<max-lifting-capacity.*>(\\d*)<.max-lifting-capacity>*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getMaxLiftingCapacity().setValue(Integer.parseInt(matcher.group(1)));
                }

                fromPattern = Pattern.compile("<name>(.*)<.name>*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getCargo().setName(matcher.group(1));
                }

                fromPattern = Pattern.compile("<class>(.*)<.class>*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getCargo().setType(matcher.group(1));
                }

                fromPattern = Pattern.compile("<delivery-date>(.*)<.delivery-date>*");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.setDeliveryDate(LocalDateTime.parse(matcher.group(1),formatter));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return box;
    }

    public static Box json(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Pattern fromPattern;
        Matcher matcher;
        BufferedReader in = createReader(string);
        String temp;
        try {
            while ((temp = in.readLine()) != null){
                fromPattern = Pattern.compile("\"from\":.\"(.*?)\"");
                matcher = fromPattern.matcher(temp);
                while(matcher.find()){
                    box.setFrom(matcher.group(1));
                }
                fromPattern = Pattern.compile("\"material\":.\"(.*?)\"");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.setMaterial(matcher.group(1));
                }
                fromPattern = Pattern.compile("\"color\":.\"(.*?)\"");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.setColor(matcher.group(1));
                }
                fromPattern = Pattern.compile("\"unit\":.\"(.*?)\"");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getMaxLiftingCapacity().setUnit(matcher.group(1));
                }

                fromPattern = Pattern.compile("\"value\":.(\\d*)");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getMaxLiftingCapacity().setValue(Integer.parseInt(matcher.group(1)));
                }

                fromPattern = Pattern.compile("\"name\":.\"(.*)\"");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getCargo().setName(matcher.group(1));
                }

                fromPattern = Pattern.compile("\"class\":.\"(.*)\"");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.getCargo().setType(matcher.group(1));
                }

                fromPattern = Pattern.compile("\"delivary-date\":.\"(.*)\"");
                matcher = fromPattern.matcher(temp);
                while (matcher.find()){
                    box.setDeliveryDate(LocalDateTime.parse(matcher.group(1),formatter));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return box;
    }
}
