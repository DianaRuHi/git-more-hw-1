package ru.gb.jseminar;

import ru.gb.jseminar.data.Notebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Homework {

    // 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    // 2) Создать множество ноутбуков.
    // 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
    //      ноутбуки, отвечающие фильтру.
    //      Пример: 1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет
    // 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ozu", "2");
        map.put("jd","256");
        map.put("os", "windows");
        map.put("color", "grey");

        Homework hw = new Homework();
        List<Notebook> notebooks = hw.initListNotebooks(1000);
        //notebooks.add(new Notebook(2, 256, 650, "windows", "grey", "lenovo"));
        List<Notebook> notebooksFiltered = hw.filter(map, notebooks);
        hw.printListOfNotebooks(notebooksFiltered);
    }

    public Notebook createNotebook(){
        Random random = new Random();
        int[] ozu = new int[]{1,2,4,8,16,32};
        int[] jd = new int[]{64,128,256,512,1024,2048};
        String[] os = new String[]{"windows","linux","macos"};
        String[] color = new String[]{"black","white","grey","red","blue","brown","green"};
        String[] company = new String[]{"hp","mac","samsung","lenovo","huaway","lg"};

        Notebook notebook = new Notebook(ozu[random.nextInt(ozu.length-1)], jd[random.nextInt(jd.length - 1)], 300 + random.nextInt(2000), 
            os[random.nextInt(os.length - 1)], color[random.nextInt(color.length - 1)], company[random.nextInt(company.length - 1)]);

        return notebook;
    }

    public List<Notebook> initListNotebooks(int size){
        List<Notebook> notebooks = new ArrayList<>();
        Homework hw = new Homework();
        for (int i = 0; i < size; i++){
            notebooks.add (hw.createNotebook());
        }

        return notebooks;
    }

    public List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks){
        List<Notebook> filtered = new ArrayList<>();
        for (Notebook item: notebooks){
            int flag = 0;
            for (String par: params.keySet()){  
                if (item.get(par).equals(params.get(par))){
                    flag += 1;
                }
            }
            if (flag == params.size()){
                filtered.add(item);
            }
        }
        return filtered;
    }

    public void printListOfNotebooks(List<Notebook> notebooks){
        String res = "[";
        for (Notebook item: notebooks){
            res += item.toString() + ", ";
        }
        res += "]";
        System.out.println(res);
    }

}
