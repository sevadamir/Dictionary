package az.orient.lesson17.map;

import java.io.*;
import java.util.*;


public class Method {

    private static final String FOLDER_PATH = "C:\\Users\\Sevinc\\IdeaProjects\\Lesson17\\FOLDER_PATH";
    private static final String FILE_PATH = FOLDER_PATH+File.separator+"dict.txt";
    public static final String DICTIONARY_PATH = "dictionary.txt";
    //public static final String DICTIONARYNEW_PATH = "dict.txt";
    private static final String LOGIN_PATH = "loginDict.txt";
    private static final String TEST_PATH = "test.txt";

    public static boolean login(String user, String pass) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(LOGIN_PATH))) {
            while (br.ready()) {
                String data = br.readLine();
                String[] dataParse = data.split("-");
                if (user.equalsIgnoreCase(dataParse[0]) && pass.equals(dataParse[1]))
                    return true;
            }
        }
        return false;
    }

    public static void writeToDictionary(String firstWord, String secondWord,String dictName) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dictName.replace("-","")+".txt", true))) {
            bw.write(firstWord + "-" + secondWord);
            bw.newLine();
        }
    }

    public static void createDictionary(String firstLang, String secondLang) throws Exception{
        new FileWriter(firstLang+secondLang+".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DICTIONARY_PATH,true))) {
            bw.write(firstLang+"-"+secondLang);
            bw.newLine();
        }
    }

    public static boolean isDictExist (String firstLang, String secondLang) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_PATH))) {
            while (br.ready()) {
                String data = br.readLine();
                String[] dataParse = data.split("-");
                if(firstLang.equals(dataParse[0]) && secondLang.equals(dataParse[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getAllDictionary () throws Exception{
        List<String> dictionary = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_PATH))) {
            while (br.ready()) {
                String data = br.readLine();
                dictionary.add(data);
            }
        }
        return dictionary;
    }

    public static String translate (String word, int dictType,String dictName) throws Exception {
        String result=null;
        Map <String,String> dictMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(dictName.replace("-","")+".txt"));
        while (br.ready()) {
            String data = br.readLine();
            String[] dataParse = data.split("-");
            dictMap.put(dataParse[0], dataParse[1]);
            dictMap.put(dataParse[1], dataParse[0]);
//            switch (dictType) {
//                case 1:
//                    dictMap.put(dataParse[0], dataParse[1]);
//                    break;
//                case 2:
//                    dictMap.put(dataParse[1], dataParse[0]);
//                    break;
//            }
        }
            if (dictMap.containsKey(word)) {
                result = dictMap.get(word);
            } else
                result = "Not found";
        dictMap.clear();
        return result;
    }
    static ArrayList<String> list = new ArrayList<String>();
    public static String[] fileToArray(String dictionaryName, int index) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(dictionaryName.replace("-","")+".txt"));
        String str;


        while ((str = br.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        list.remove(index);
        String[] stringArr = list.toArray(new String[0]);
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println(i + " " + stringArr[i]);
        }
        return stringArr;
    }


    public static void fileToArrayReader(String dictionaryName) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(dictionaryName.replace("-","")+".txt"));

        String str;
        ArrayList<String> list = new ArrayList<String>();
        while ((str = br.readLine()) != null) {
            if(!str.isEmpty()) {
                list.add(str);
            }
        }
        String[] stringArr = list.toArray(new String[0]);
        for (int i=0; i < stringArr.length; i++) {
            System.out.println(i+" " +stringArr[i]);
        }
    }

    public static void deleteFromDict (String[] stringArr, String dictionaryName) throws Exception{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dictionaryName.replace("-","")+".txt"));
        for (String word:stringArr) {
            bufferedWriter.write(word);
            bufferedWriter.write(" ");
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
    }
    public static String[] fileToArrayReplace(String dictionaryName, int indexRepl,String word) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(dictionaryName.replace("-","")+".txt"));
        String str;


        while ((str = br.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        list.set(indexRepl,word);
        String[] stringArrRepl = list.toArray(new String[0]);
        for (int i = 0; i < stringArrRepl.length; i++) {
            System.out.println(i + " " + stringArrRepl[i]);
        }
        return stringArrRepl;
    }

    public static void replaceFromDict (String[] stringArrRepl, String dictionaryName) throws Exception{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dictionaryName.replace("-","")+".txt"));
        for (String word:stringArrRepl) {
            bufferedWriter.write(word);
            bufferedWriter.write(" ");
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
    }
}
