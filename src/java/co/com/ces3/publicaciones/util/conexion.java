package co.com.ces3.publicaciones.util;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;

import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class conexion {
    DB db = null;
    public conexion() {
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDB("publications");
    }

    public DB getConnection() {
        return db;
    }
    
    /*public static void main(String[] args) {
        DB cone = null;

        conexion c = new conexion();
        cone = c.getConnection();
        DBCollection coll = cone.getCollection("users");
        BasicDBObject fields = new BasicDBObject();
        fields.put("email", "cristianhoyos66@hotmail.com");
        fields.put("pass", "123123123");
        DBObject val = null;
        try (DBCursor cursor = coll.find(fields)) {
            while(cursor.hasNext()) {
                val = cursor.next();
            }
        }
        if(val != null){
            System.out.println(val);
        }
        
    }*/

}
