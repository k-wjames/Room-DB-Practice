package ke.co.ideagalore.roomdb.Repositories;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ke.co.ideagalore.roomdb.Models.CardModel;

@Dao
public interface UserCardDao {
    //Inserting
    @Insert(onConflict = REPLACE)
    void insert(CardModel cardModel);

    //Deleting a single item
    @Delete
    void delete(CardModel cardModel);

    //Deleting all
    @Delete
    void reset(List<CardModel> cardModels);

    //Updating
    @Query("UPDATE my_cards SET name=:sName, designation=:sDesignation, organisation=:sOrganisation, city=:sCity,email=:sEmail," +
            "directLine=:sDirectLine, mobileLine=:sMobileLine, fax=:sFax where ID=:sID ")
    void update(int sID, String sName, String sDesignation,String sOrganisation, String sCity, String sEmail, double sDirectLine,
                double sMobileLine, double sFax);

    //Getting a list of all the data in database
    @Query("SELECT * FROM my_cards")
    List<CardModel> getAllUserCards();
}
