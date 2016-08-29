package alexnik0888.yalantistask.ui.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import alexnik0888.yalantistask.R;
import alexnik0888.yalantistask.data.DbManager;
import alexnik0888.yalantistask.ui.activities.facebook.FbActivity;
import alexnik0888.yalantistask.ui.fragments.tab.TabFragment;
import alexnik0888.yalantistask.adapters.PagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Main class for app.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.fab) FloatingActionButton mFab;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.nav_view) NavigationView mNavView;
    @BindView(R.id.tabs) TabLayout mTabLayout;
    @BindView(R.id.pager) ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
        mNavView.setNavigationItemSelectedListener(this);
        setupViewPager(mPager);
        mTabLayout.setupWithViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //setting
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_all_questions) {

        } else if (id == R.id.nav_map_questions) {

        } else if (id == R.id.nav_enter) {
            startActivity(new Intent(this, FbActivity.class));
        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(TabFragment.createFragment(DbManager.STATE_IN_PROGRESS), getString(R.string.in_process));
        adapter.addFragment(TabFragment.createFragment(DbManager.STATE_DONE), getString(R.string.ended));
        adapter.addFragment(TabFragment.createFragment(DbManager.STATE_WAITING), getString(R.string.waiting));
        viewPager.setAdapter(adapter);
    }
}
