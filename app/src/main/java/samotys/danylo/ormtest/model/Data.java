package samotys.danylo.ormtest.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import samotys.danylo.ormtest.data.Repo;

/**
 * Created by Danylo on 19.04.15.
 */
@DatabaseTable (tableName = "test")
public class Data {

    @DatabaseField (generatedId = true)
    private int id;

    @DatabaseField (dataType = DataType.STRING)
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Data() {};

    public Data(String data) {
        this.data = data;
    }

    public int save(Repo repo)
    {
        if(repo.Users.getByData(data) == null) {
            return repo.Users.create(this);
        }
        else
        {
            return repo.Users.update(this);
        }
    }

    public int delete(Repo repo)
    {
        return repo.Users.delete(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
