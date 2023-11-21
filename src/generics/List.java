package generics;

public class List {
    private int[] items = new int[10];

    public int getCount(int count) {
        return count;
    }
    public int get(int index){
        return items[index];
    }

    private int count =0;


    public void  add(int item){
        items[count] = item;
        count++;
    }

}
