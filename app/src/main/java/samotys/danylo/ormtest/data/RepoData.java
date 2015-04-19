package samotys.danylo.ormtest.data;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;

import samotys.danylo.ormtest.model.Data;

/**
 * Created by Danylo on 19.04.15.
 */
public class RepoData {

    Dao<Data, String> dataDao;

    public RepoData(DBHelper db) {
        try {
            dataDao = db.getDataDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(Data data) {
        try {
            return dataDao.create(data);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public Data getByData(String data) {
        try {
            QueryBuilder<Data, String> qb = dataDao.queryBuilder();

            qb.where().eq(DBHelper.DATA_COLUMN_DATA, data);

            PreparedQuery<Data> pq = qb.prepare();
            return dataDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public int update(Data data) {
        try {
            return dataDao.update(data);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Data data) {
        try {
            return dataDao.delete(data);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
}
