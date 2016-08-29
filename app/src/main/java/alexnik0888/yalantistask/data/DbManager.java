package alexnik0888.yalantistask.data;

import android.util.Log;

import java.util.List;

import alexnik0888.yalantistask.adapters.FragRecyclerAdapter;
import alexnik0888.yalantistask.model.Task;
import alexnik0888.yalantistask.utils.ApiService;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alex on 13.08.2016.
 */
public class DbManager {

    public static final String STATE_IN_PROGRESS = "0,9,5,7,8";
    public static final String STATE_DONE = "10,6";
    public static final String STATE_WAITING = "1,3,4";

    private static final String BASE_STATE_IN_PROGRESS = "В роботі";
    private static final String BASE_STATE_DONE = "Виконано";
    private static final String BASE_STATE_WAITING = "На модерації";
    private static final String TAG = "DbManager";
    private static final int AMOUNT = 20;

    private Realm mRealm;

    public Task getTask(int id){
        return mRealm.where(Task.class).equalTo("id", id).findFirst();
    }

    public DbManager() {
        mRealm = Realm.getDefaultInstance();
    }

    public List<Task> getTasks(String state){
        String name = getStateName(state);
        return mRealm.where(Task.class).equalTo("state.name", name).findAll();
    }


    private String getStateName (String state){
        switch (state){
            case STATE_IN_PROGRESS:
                return BASE_STATE_IN_PROGRESS;
            case STATE_DONE:
                return BASE_STATE_DONE;
            case STATE_WAITING:
                return BASE_STATE_WAITING;
            default:
                return null;
        }
    }

    public void downloadData(String state, int offset, final FragRecyclerAdapter adapter, final List<Task> list){
        ApiService service = ApiService.Factory.newApiService();
        service.getTasks(offset, state, AMOUNT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Task>>() {
                    @Override
                    public void onCompleted() {
                        Log.v(TAG, "Download completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Task> tasks) {
                        mRealm.beginTransaction();
                        mRealm.copyToRealmOrUpdate(tasks);
                        mRealm.commitTransaction();

                        list.addAll(tasks);
                        adapter.notifyDataSetChanged();
                    }
                });


    }
}
