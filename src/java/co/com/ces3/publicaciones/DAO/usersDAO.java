package co.com.ces3.publicaciones.DAO;

import co.com.ces3.publicaciones.util.conexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class usersDAO {
    private DB con = null;
    
    public usersDAO(){
        conexion c = new conexion();
        con = c.getConnection();
    }
    
    public boolean consultarUsuario(String email, String pass){
        boolean flag = false;
        DBObject val = null;
        DBCollection coll = con.getCollection("users");
	BasicDBObject fields = new BasicDBObject();
        fields.put("email", email);
        fields.put("pass", pass);
        try (DBCursor cursor = coll.find(fields)) {
            while(cursor.hasNext()) {
                val = cursor.next();
            }
        }
        if(val != null){
            flag = true;
        }
        return flag;
    }
    
}
