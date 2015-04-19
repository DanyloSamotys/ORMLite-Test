package samotys.danylo.ormtest.data;

import android.content.Context;

/**
 * Created by Danylo on 19.04.15.
 */
public class Repo {

    DBHelper db;

    public RepoData Data;

    public Repo(Context context) {

        db = new DBHelper(context);

        Data = new RepoData(db);

    }
}
