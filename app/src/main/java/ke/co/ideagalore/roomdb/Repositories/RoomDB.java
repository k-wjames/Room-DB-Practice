package ke.co.ideagalore.roomdb.Repositories;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ke.co.ideagalore.roomdb.Models.CardModel;

@Database(entities = {CardModel.class},version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    //Create room database instance
    private static RoomDB  database;

    //Defining the database name
    private static String DATABASE_NAME="RoomDB";

    public synchronized static RoomDB getInstance(Context context){

        //Check if condition

        if (database==null){
            //if database is equal to null, initialize the database
            database= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class,
                    DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        //Now return the database
        return database;

    }

    //Now lets create DAO

    public abstract UserCardDao userCardDao();

}
