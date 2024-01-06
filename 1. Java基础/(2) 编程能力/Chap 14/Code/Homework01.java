package com.tybxx.Homework;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if(arrayList.get(i) instanceof News){
                News tempNews = (News) arrayList.get(i);
                if(tempNews.getCaption().length() <= 15){
                    continue;
                }
                String truncCaption;
                truncCaption = tempNews.getCaption().substring(0,14) + "...";
                tempNews.setCaption(truncCaption);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj =  it.next();
            System.out.println(obj);
        }
    }
}


@SuppressWarnings({"all"})
class News{
    private String caption;
    private String content;

    public News(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "caption='" + caption + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

