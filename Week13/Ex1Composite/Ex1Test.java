import java.util.ArrayList;
import java.util.List;

public class Ex1Test {
    public static void main(String[] args) {
        Person nvh = new Person("NVH", "12/05/2002", "Male", "HTH");

        Person f11 = new Person("F11", "11/12/2021", "Male", null);
        Person f12 = new Person("F12", "11/12/2021", "Male", "G11");
        nvh.addChild(f11);
        nvh.addChild(f12);

        Person f21 = new Person("F21", "11/12/2042", "Male", "H11");
        Person f22 = new Person("F22", "11/12/2042", "Female", "H12");
        Person f23 = new Person("F23", "11/12/2050", "Male", null);
        Person f24 = new Person("F24", "11/12/2050", "Female", null);
        f12.addChild(f21);
        f12.addChild(f22);
        f12.addChild(f23);
        f12.addChild(f24);

        Person f31 = new Person("F31", "11/12/2069", "Male", null);
        Person f32 = new Person("F32", "11/12/2069", "Female", null);
        Person f33 = new Person("F33", "11/12/2070", "Female", "I11");
        f21.addChild(f31);
        f21.addChild(f32);
        f22.addChild(f33);

        /*
                            NVH   -   HTH
                            /           \
                           F11         F12    -    G11
                                     /         |    |  \
                             H11 - F21  H12 - F22  F23 F24
                               /   \        |
                             F31   F32     F33 - I11
        */

        List<Person> listPersonNotMarried = new ArrayList<>();
        List<String> listFamilyHasTwoChildren = new ArrayList<>();
        List<Person> listPersonOfTheLastGeneration = new ArrayList<>();

        List<Person> listPerson = new ArrayList<>();
        List<Integer> listCheck = new ArrayList<>();
        listPerson.add(nvh);
        while (!listPerson.isEmpty()) {
            int size = listPerson.size();
            boolean check = true;
            for (int i = 0; i < size; i++)
                if (listPerson.get(i).getMarried() == null) listCheck.add(i, -1);
                else {
                    listCheck.add(i, listPerson.get(i).getChildren().size());
                    if (check && listCheck.get(i) > 0) check = false;
                }

            if (check) {
                listPersonOfTheLastGeneration.addAll(listPerson);
                for (int i = 0; i < size; i++)
                    if (listCheck.get(i) == -1) listPersonNotMarried.add(listPerson.get(i));
                listPerson.clear();
            } else {
                List<Person> nextListPerson = new ArrayList<>();
                for (int i = 0; i < size; i++)
                    if (listCheck.get(i) == -1) listPersonNotMarried.add(listPerson.get(i));
                    else if (listCheck.get(i) > 0) {
                        nextListPerson.addAll(listPerson.get(i).getChildren());
                        if (listCheck.get(i) == 2) listFamilyHasTwoChildren.add(listPerson.get(i).getName() + " - " + listPerson.get(i).getMarried());
                    }
                listPerson.clear();
                listPerson.addAll(nextListPerson);
            }
        }

        System.out.println("Các cá nhân chưa kết hôn trong danh sách phả hệ:");
        for (Person person : listPersonNotMarried) System.out.println("\t" + person);

        System.out.println("\nCác cặp vợ chồng có 2 con trong danh sách phả hệ:");
        for (String family : listFamilyHasTwoChildren) System.out.println("\t" + family);

        System.out.println("\nThế hệ mới nhất trong danh sách phả hệ:");
        for (Person person : listPersonOfTheLastGeneration) System.out.println("\t" + person);
    }
}
