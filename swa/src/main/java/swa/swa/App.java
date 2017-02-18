package swa.swa;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        System.out.println( "Hello World!" );
        DB db = new MongoClient("localhost"	,	27017).getDB("simple");
        DBCollection dBCollection = db.getCollection("one");
        
    }
}
