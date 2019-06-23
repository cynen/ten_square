package com.myth.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoTest {
    public static void main(String[] args) {
        // 创建链接对象
        MongoClient client = new MongoClient("47.107.177.108",8380);

        //选择对应的数据库
        MongoDatabase database = client.getDatabase("splitdb");
        // 选择对应的集合
        MongoCollection collection = database.getCollection("split");
        // 添加查询
        // BasicDBObject bson  = new BasicDBObject("_id","2"); //根据ID查询
        // 根据Score查询,大于1000的记录.
        BasicDBObject bson  = new BasicDBObject("score",new BasicDBObject("$gt",1000));

        // 根据条件查询.
        FindIterable<Document> documents  = collection.find(bson);
        for (Document document : documents) {
            System.out.print(document.getString("_id"));
            System.out.print(document.getString("name"));
            System.out.print(document.getInteger("age"));
            System.out.print(document.getInteger("score"));
            System.out.println();
        }
    }
}
