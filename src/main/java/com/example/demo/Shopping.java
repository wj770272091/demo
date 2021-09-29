package com.example.demo;

import java.util.ArrayList;

/**
 * @NAME: Shopping
 * @USER: 77027
 * @DATE: 2020/10/23
 * @TIME: 15:43
 */
public class Shopping {
    /**
     * 组合模式测试
     */
    public static void main(String[] args) {
        float s = 0;
        Bags BigBag, mediumBag, smallRedBag, smallWhiteBag;
        Goods goods;
        BigBag=new Bags("大袋子");
        mediumBag=new Bags("中号袋子");
        smallRedBag=new Bags("小号红色袋子");
        smallWhiteBag=new Bags("小号白色袋子");
        goods=new Goods("婺源特产",2,7.9f);
        smallRedBag.add(goods);
        goods=new Goods("婺源地图",1,9.9f);
        smallRedBag.add(goods);
        goods=new Goods("韶关香菇",2,68);
        smallWhiteBag.add(goods);
        goods=new Goods("韶关红茶",3,180);
        smallWhiteBag.add(goods);
        goods=new Goods("景德镇瓷器",1,380);
        mediumBag.add(goods);
        mediumBag.add(smallRedBag);
        goods=new Goods("李宁牌运动鞋",1,198);
        BigBag.add(goods);
        BigBag.add(smallWhiteBag);
        BigBag.add(mediumBag);
        System.out.println("您选购的商品有:");
        BigBag.show();
        System.out.println("价格总计:"+BigBag.calculation()+"元");
    }
}

interface Articles {
    float calculation();

    void show();
}

class Goods implements Articles {
    private String name;
    private int quantity;
    private float unitPrice;

    public Goods(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calculation() {
        return quantity * unitPrice;
    }

    @Override
    public void show() {
        System.out.println(name + "数量:" + quantity + ",单价:" + unitPrice);
    }
}

class Bags implements Articles {
    private String name;
    private ArrayList<Articles> bags = new ArrayList<Articles>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles articles) {
        bags.add(articles);
    }

    public void remove(Articles articles) {
        bags.remove(articles);
    }

    public Articles getChild(int i) {
        return bags.get(i);
    }


    @Override
    public float calculation() {
        float s = 0;
        for (Articles articles : bags) {
            s += articles.calculation();
        }
        return s;
    }

    @Override
    public void show() {
        for (Articles articles : bags) {
            articles.show();
        }
    }
}
