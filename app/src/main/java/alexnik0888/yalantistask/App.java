package alexnik0888.yalantistask;

import android.app.Application;

import com.facebook.FacebookSdk;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Alex on 14.08.2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.deleteRealm(realmConfig);
        Realm.setDefaultConfiguration(realmConfig);

        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
