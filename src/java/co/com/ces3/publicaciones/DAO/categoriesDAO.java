package co.com.ces3.publicaciones.DAO;

import co.com.ces3.publicaciones.model.categories;
import co.com.ces3.publicaciones.util.conexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class categoriesDAO {
    private DB con = null;
    DBCollection coll = null; 
    public categoriesDAO(){
        conexion c = new conexion();
        con = c.getConnection();
        coll = con.getCollection("categories");
    }
    
    public List<categories> consultCategories(){
        List<categories> categories = new ArrayList<categories>();
        try (DBCursor cursor = coll.find()) {
            while(cursor.hasNext()) {
                categories Categories = new categories();
                BasicDBObject obj = (BasicDBObject) cursor.next();
                Categories.setId(obj.getString("_id"));
                Categories.setTitulo(obj.getString("title"));
                Categories.setDescripcion(obj.getString("descripcion"));
                categories.add(Categories);
            }
        }
         return categories;
    } 
    
    public void createCategory(categories Categories) {
      BasicDBObject fields = new BasicDBObject();
      fields.put("title", Categories.getTitulo());
      fields.put("descripcion", Categories.getDescripcion());
      coll.insert(fields);
    }
    
    public void deleteCategory(String id) {
      BasicDBObject fields = new BasicDBObject();
      ObjectId idCategory = new ObjectId(id);
      fields.put("_id", idCategory);
      coll.remove(fields);
    }
    
    public void updateCategory(categories Categories) {
      BasicDBObject idUpdate = new BasicDBObject();
      BasicDBObject sentenceUpdate = new BasicDBObject();
      BasicDBObject secondSentenceUpdate = new BasicDBObject();
      ObjectId idCategory = new ObjectId(Categories.getId());
      idUpdate.put("_id", idCategory);
      secondSentenceUpdate.put("title", Categories.getTitulo());
      secondSentenceUpdate.put("descripcion", Categories.getDescripcion());
      sentenceUpdate.put("$set", secondSentenceUpdate);
      coll.update(idUpdate, sentenceUpdate);
    }
    
}
