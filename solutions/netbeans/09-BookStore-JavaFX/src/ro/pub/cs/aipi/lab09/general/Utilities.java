package ro.pub.cs.aipi.lab09.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    public static String tableNameToMenuEntry(String tableName) {
        return tableName.replaceAll("_", " ");
    }

    public static String menuEntryToTableName(String menuEntry) {
        return menuEntry.replaceAll(" ", "_");
    }

    public static String compress(List<String> record) {
        String result = record.get(0);
        for (int position = 1; position < record.size(); position++) {
            result += " # " + record.get(position);
        }
        return result;
    }

    public static List<String> decompress(String record) {
        List<String> result = new ArrayList<>(Arrays.asList(record.split("#")));
        for (int position = 0; position < result.size(); position++) {
            result.set(position, result.get(position).trim().replace("'", "\\'"));
        }
        return result;
    }

    public static String escape(String text) {
        return text.replace("'", "\\'");
    }
}
