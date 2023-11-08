package controllers;

public class SearchController {
    private int m = 10;
    private int n = 100;

    public SearchController(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public String toString() {
        return "SearchController{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }

    public static void main(String[] args){

        SearchController hello = new SearchController(3,4);
        System.out.println(hello.toString());
    }

}