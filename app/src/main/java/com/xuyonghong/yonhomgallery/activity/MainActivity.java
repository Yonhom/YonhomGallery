package com.xuyonghong.yonhomgallery.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.xuyonghong.yonhomgallery.R;
import com.xuyonghong.yonhomgallery.fragment.AlbumFragment;
import com.xuyonghong.yonhomgallery.util.ViewManager;
import com.xuyonghong.yonhomgallery.view.ThemeableToolBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final int ALBUM_FRAMGENT_CONTAINER_ID = 100;

    /**
     * this customized toolbar
     */
    @BindView(R.id.my_tool_bar)
    ThemeableToolBar toolbar;
    /**
     * the album fragment container
     */
    @BindView(R.id.album_fragment_container)
    FrameLayout albumFragmentContainer;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
    }

    /**
     * load the toolbar and the framgnet for showing images
     */
    private void initUI() {
        // this method has to be called for the toolbar to be shown
        setSupportActionBar(toolbar);

        // set a id for the album fragment container
        //noinspection ResourceType
        albumFragmentContainer.setId(ALBUM_FRAMGENT_CONTAINER_ID);

        // creat & add a album fragment to the main screen
        AlbumFragment albumFragment = new AlbumFragment();
        ViewManager.loadFragment(this, albumFragment, ALBUM_FRAMGENT_CONTAINER_ID);

        // drawer toggle: is also a drawerlayout listener
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.drawer_open_desc,
                R.string.drawer_close_desc) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.i(TAG, "left drawer closed!");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.i(TAG, "left drawer opened!");
            }
        };
        // set the drawer toggle listener to the toggle button
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.syncState();
    }

    /**
     * call back when the item on the action bar is clicked
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // if the burger button is selected, let drawtoggle handle the selection action
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
