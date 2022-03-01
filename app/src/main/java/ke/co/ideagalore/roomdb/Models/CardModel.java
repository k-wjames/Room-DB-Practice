package ke.co.ideagalore.roomdb.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "my_cards")
public class CardModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="designation")
    String designation;

    @ColumnInfo(name="organisation")
    String organisation;

    @ColumnInfo(name="city")
    String city;

    @ColumnInfo(name="email")

    String email;
    @ColumnInfo(name = "directLine")
    double directLine;

    @ColumnInfo(name="mobileLine")
    double mobileLine;

    @ColumnInfo(name="fax")
    double fax;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDirectLine() {
        return directLine;
    }

    public void setDirectLine(double directLine) {
        this.directLine = directLine;
    }

    public double getMobileLine() {
        return mobileLine;
    }

    public void setMobileLine(double mobileLine) {
        this.mobileLine = mobileLine;
    }

    public double getFax() {
        return fax;
    }

    public void setFax(double fax) {
        this.fax = fax;
    }
}
