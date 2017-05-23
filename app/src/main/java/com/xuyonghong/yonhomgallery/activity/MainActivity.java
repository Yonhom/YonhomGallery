package com.xuyonghong.yonhomgallery.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.xuyonghong.yonhomgallery.R;
import com.xuyonghong.yonhomgallery.fragment.AlbumFragment;
import com.xuyonghong.yonhomgallery.view.ThemeableToolBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
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
        loadFragment(albumFragment);
    }

    /**
     * replace the container's child view with the fragment's view
     * @param albumFragment the fragment to replace the old view
     */
    private void loadFragment(AlbumFragment albumFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //noinspection ResourceType
        fragmentTransaction.replace(ALBUM_FRAMGENT_CONTAINER_ID,
                albumFragment, AlbumFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
