package az.orient.lesson17.map;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, String> map1 = new HashMap<>();
        Map<String, String[]> dict = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("admin or user");
            switch (sc.next()) {
                case "admin":
                    System.out.println("Login ve parolu daxil edin");
                    String login = sc.next();
                    String pass = sc.next();
                    if (!Method.login(login, pass)) {
                        System.err.println("Invalid username or password");
                        return;
                    } else {
                        System.out.println("Hansi funksiyani ise salmaq isteyirsiniz? " +
                                "\n1.Yeni luget yaratmaq 2. Secilmis lugete yeni soz elave etmek " +
                                "\n3. Secilmis lugetden soz silmek 4. Secilmis lugetde sozu deyismek");
                        switch (sc.nextInt()) {
                            case 1:
                                List<String> dictionary = Method.getAllDictionary();
                                System.out.println("Movcud olunan lugetler \n"+dictionary);
                                System.out.println("Lugeti qeyd edin");
                                System.out.println("Enter firstLang:");
                                String firstLang = sc.next();
                                System.out.println("Enter secondLang");
                                String secondLang = sc.next();
                                if (Method.isDictExist(firstLang, secondLang)) {
                                    System.out.println("Bele bir luget movcuddur.");
                                } else {
                                    Method.createDictionary(firstLang, secondLang);
                                    System.out.println("The dictionary has been successfully created!");
                                }
                                break;
                            case 2:
                                System.out.println(Method.getAllDictionary());
                                System.out.println("Which dictionary?");
                                String dictName = sc.next();
                                System.out.println("Ilk sozu daxil edin");
                                String firstWord = sc.next();
                                System.out.println("Ikinci sozu daxil edin");
                                String secondWord = sc.next();
                                Method.writeToDictionary(firstWord, secondWord, dictName);
                                System.out.println("The word has been successfully added");
                                break;
                            case 3:
                                System.out.println(Method.getAllDictionary());
                                System.out.println("Which dictionary?");
                                String dictionaryName = sc.next();
                                Method.fileToArrayReader(dictionaryName);
                                System.out.println("Silmek istediyiniz sozun index-ini qeyd edin");
                                int index = sc.nextInt();
                                String[] stringArr = Method.fileToArray(dictionaryName, index);
                                Method.deleteFromDict(stringArr,dictionaryName);
                                break;
                            case 4:
                                System.out.println(Method.getAllDictionary());
                                System.out.println("Which dictionary?");
                                String dictionaryNameRepl = sc.next();
                                Method.fileToArrayReader(dictionaryNameRepl);
                                System.out.println("Deyismek istediyiniz sozun index-ini qeyd edin");
                                int indexRepl = sc.nextInt();
                                System.out.println("Deyismek istediyiniz sozu qeyd edin");
                                String word = sc.next();
                                String[] stringArrRepl = Method.fileToArrayReplace(dictionaryNameRepl, indexRepl,word);
                                Method.replaceFromDict(stringArrRepl,dictionaryNameRepl);
                                break;
                        }
                        break;
                    }
                case "user":
                    String result;
                    System.out.println("1. Lugetleri gormek 2. Translate etmek");
                    switch (sc.nextInt()) {
                        case 1:
                            List<String> dictionary = Method.getAllDictionary();
                            System.out.println(dictionary);
                            break;
                        case 2:
                            System.out.println("Lugetlerden birini secin");
                            List<String> dictionary1 = Method.getAllDictionary();
                            System.out.println(dictionary1);
                            String dictName = sc.next();
                            System.out.println("Enter word");
                            result = Method.translate(sc.next(), 2,dictName);
                            System.out.println("Result: " + result);
                            break;
                        default:
                            System.out.println("Invalid dictionary!");

                    }
                    break;
                default:
                    System.out.println("Invalid role");
                    main(args);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}