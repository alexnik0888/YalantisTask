package alexnik0888.yalantistask.ui.activities.main;


import android.support.v4.app.Fragment;

import java.util.List;


/**
 * Created by Alex on 04.08.2016.
 */
public interface MainView {
    void initTabs(List<Fragment> tabs);
    void showNavDrawer();
}
