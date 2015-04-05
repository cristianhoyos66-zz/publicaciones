package co.com.ces3.publicaciones.DAO;

import co.com.ces3.publicaciones.model.categories;
import co.com.ces3.publicaciones.model.publications;
import co.com.ces3.publicaciones.util.conexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class publicationsDAO {
    private DB con = null;
    DBCollection coll = null;
    DBCollection coll2 = null;
    public publicationsDAO(){
        conexion c = new conexion();
        con = c.getConnection();
        coll = con.getCollection("publications");
        coll2 = con.getCollection("categories");
    }
    
    public List<publications> consultPublications(){
        List<publications> publications = new ArrayList<publications>();
        String idCategory = null;
        try (DBCursor cursor = coll.find()) {
            while(cursor.hasNext()) {
                publications Publications = new publications();
                BasicDBObject obj = (BasicDBObject) cursor.next();
                idCategory = obj.getString("category");
                Publications.setId(obj.getString("_id"));
                Publications.setTitulo(obj.getString("title"));
                Publications.setCategoria(consultCategory(idCategory));
                Publications.setContenido(obj.getString("description"));
                publications.add(Publications);
            }
        }
         return publications;
    }
    
    public String consultCategory(String idCategory){
        String category = null;
        BasicDBObject fields = new BasicDBObject();
        ObjectId id = new ObjectId(idCategory);
        fields.put("_id", id);
        System.out.println(fields);
        try (DBCursor cursor = coll2.find(fields)) {
            while(cursor.hasNext()) {
                BasicDBObject obj = (BasicDBObject) cursor.next();
                category = obj.getString("title");
            }
        }
        return category;
    }
         
    public void createPublication(publications Publications) {
      BasicDBObject fields = new BasicDBObject();
      fields.put("title", Publications.getTitulo());
      fields.put("category", Publications.getCategoria());
      fields.put("description", Publications.getContenido());
      coll.insert(fields);
    }
    
    public void deletePublication(String id) {
      BasicDBObject fields = new BasicDBObject();
      ObjectId idCategory = new ObjectId(id);
      fields.put("_id", idCategory);
      coll.remove(fields);
    }
    
    public void updatePublication(publications Publications) {
      BasicDBObject idUpdate = new BasicDBObject();
      BasicDBObject sentenceUpdate = new BasicDBObject();
      BasicDBObject secondSentenceUpdate = new BasicDBObject();
      ObjectId idCategory = new ObjectId(Publications.getId());
      idUpdate.put("_id", idCategory);
      secondSentenceUpdate.put("title", Publications.getTitulo());
      secondSentenceUpdate.put("category", Publications.getCategoria());
      secondSentenceUpdate.put("description", Publications.getContenido());
      sentenceUpdate.put("$set", secondSentenceUpdate);
      coll.update(idUpdate, sentenceUpdate);
    }
}
